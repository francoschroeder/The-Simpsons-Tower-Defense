package Juego;

import java.awt.Point;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import GUI.GUIPrincipal;
import PowerUp.*;

public class Juego {
	
	private final Point OBSTACULO_1;
	private final Point OBSTACULO_2;
	
	private int tc;
	private Personaje [][] matriz;
	private LinkedList<Comprable> aliadosActivos;
	private LinkedList<Enemigo> enemigosActivos;
	private LinkedList<Objeto> objetosActivos;
	private GUIPrincipal gui;
	
	public Juego(GUIPrincipal p) 
		{
		OBSTACULO_1 = new Point(2, 2);
		OBSTACULO_2 = new Point(5, 2);
		
		// asignar las listas
		this.gui=p;
		aliadosActivos =  new LinkedList<Comprable>();
		enemigosActivos =  new LinkedList<Enemigo>();
		objetosActivos = new LinkedList<Objeto>();
		matriz = new Personaje[6][10]; //matriz[fila][columna]
		tc=75;
		
		JLabel obst1 = new JLabel();
		obst1.setIcon(new ImageIcon(this.getClass().getResource("/sprites/barney/barneyNeutral.gif")));
		obst1.setBounds(0, 0, 75, 75);
		gui.getPanelMapa().add(obst1);
		obst1.setLocation((int) OBSTACULO_1.getY()*75, (int) OBSTACULO_1.getX()*75);
		
		JLabel obst2 = new JLabel();
		obst2.setIcon(new ImageIcon(this.getClass().getResource("/sprites/barney/barneyAttack.gif")));
		obst2.setBounds(0, 0, 75, 75);
		
		
		gui.getPanelMapa().add(obst2);
		obst2.setLocation((int) OBSTACULO_2.getY()*75, (int) OBSTACULO_2.getX()*75);
		
		}
	
	public void agregarPersonaje(Enemigo p, Point punto) {
		
		gui.getPanelMapa().add(p.getImagen());
		p.getImagen().setLocation((int)(punto.getY())*75+1,(int)(punto.getX())*75);
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		p.actualizarVida();
		gui.getPanelMapa().add(p.getBarraDeVida());
		p.getImagen().setVisible(true);
		p.getBarraDeVida().setVisible(true);
		synchronized (enemigosActivos) {enemigosActivos.add(p);}
		
		gui.getPanelMapa().validate();
		gui.getPanelMapa().repaint();
	}
	
	public void agregarPersonaje(Comprable p, Point punto) {
		p.setPosicion(punto);
		gui.getPanelMapa().add(p.getImagen());
		p.getImagen().setLocation((int)p.getPosicion().getY()*75,(int) p.getPosicion().getX()*75);;
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		mostrarMatriz();
		p.actualizarVida();
		gui.getPanelMapa().add(p.getBarraDeVida());
		p.getImagen().setVisible(true);
		p.getBarraDeVida().setVisible(true);
		synchronized (aliadosActivos) {aliadosActivos.add(p);}
		
		gui.getPanelMapa().validate();
		gui.getPanelMapa().repaint();
	}
	
	public void agregarPersonaje(Objeto o, Point punto) {
		gui.getPanelMapa().add(o.getImagen());
		o.getImagen().setLocation((int)(punto.getY())*75,(int)(punto.getX())* 75);
		matriz[(int)punto.getX()][(int)punto.getY()] = o;
		o.getImagen().setVisible(true);
		synchronized (objetosActivos) {objetosActivos.add(o);}
		
		gui.getPanelMapa().validate();
		gui.getPanelMapa().repaint();
	}
	
	public Personaje getBlanco(Enemigo p) {
		int x = (int) p.getPosicion().getX();
		int rango = (int) p.getPosicion().getY() + p.getRango();
		
		for(int i = (int) p.getPosicion().getY(); i <= rango && i<=8; i++){
			
			if (matriz[x][i+1] != null)
				return matriz[x][i+1];
		}
		
		return null;	
	}
	
	public Personaje getBlanco(Comprable p) {
		int x = (int) p.getPosicion().getX();
		int rango = (int) p.getPosicion().getY() - p.getRango();
		
		for(int i =  (int) p.getPosicion().getY(); i >= rango && i>=1; i--){
			
			if (matriz[x][i-1] != null)
				return matriz[x][i-1];
		}
		
		return null;
	}
	
	
	/*Avanza el enemigo 1 cuadro hacia adelante
	 * Retorna true si se pudo avanzar (si no hay nadie en frente) y false en caso contrario
	 */
	public boolean moverEnemigo(Enemigo e) {
		Point posE = e.getPosicion();
		
		if (((int) posE.getY() != 9) && (matriz[((int) posE.getX())][(int) posE.getY()+1] == null)) {
			matriz[((int) posE.getX())][(int) posE.getY()+1] = matriz[(int) posE.getX()][(int) posE.getY()];
			matriz[(int) posE.getX()][(int) posE.getY()] = null;
			e.setPosicion(new Point((int)( posE.getX()), (int) posE.getY()+1));
			e.getImagen().setLocation((int) e.getPosicion().getY()*75, (int) e.getPosicion().getX()*75);
			this.mostrarMatriz();
			return true;
			
		}
			
		return false;
	}
	
	
	public void eliminar(Enemigo p) {
		
		gui.getPanelMapa().remove(p.getImagen());
		gui.getPanelMapa().validate();
		gui.getPanelMapa().repaint();
		synchronized (enemigosActivos) {enemigosActivos.remove(p);}
		matriz[(int) p.getPosicion().getX()][(int) p.getPosicion().getY()] = null;
		gui.getMarket().sumarMonedas(p.serEliminado());
		gui.actualizarCartel();		
		double x = Math.random();
		
		HashMap<String,PowerUp> mapeoPowerUp = new HashMap<String,PowerUp>();
		mapeoPowerUp.put("bomba", new Bomba());	
		mapeoPowerUp.put("curacion", new Curacion());
		mapeoPowerUp.put("magiaAlcance", new MagiaAlcance());
		mapeoPowerUp.put("magiaAtaque", new MagiaAtaque());
		
		//15% de posibilidades de generar powerUp
		//Bomba, curacion, magia alcance, magia ataque
		
		if (x<=0.15){ 				
			Random generator = new Random();
			Object[] powerUps = mapeoPowerUp.values().toArray();
			PowerUp randomPowerUp = (PowerUp) powerUps[generator.nextInt(powerUps.length)];
			
			//PowerUp aPoner = randomPowerUp.clone();
		}		
	}
	
	public void eliminar(Comprable p) {
		gui.getPanelMapa().remove(p.getImagen());
		gui.getPanelMapa().validate();
		gui.getPanelMapa().repaint();
		synchronized (aliadosActivos) {aliadosActivos.remove(p);}
		matriz[(int) p.getPosicion().getX()][(int) p.getPosicion().getY()] = null;
	}
	
	public void eliminar(Objeto o) {
		gui.getPanelMapa().remove(o.getImagen());
		gui.getPanelMapa().validate();
		gui.getPanelMapa().repaint();
		synchronized (objetosActivos) {objetosActivos.remove(o);}
		matriz[(int) o.getPosicion().getX()][(int) o.getPosicion().getY()] = null;
	}
	
	public LinkedList<Enemigo> getEnemigos() {
		return enemigosActivos;
	}
	
	public LinkedList<Comprable> getAliados() {
		return aliadosActivos;
	}
	
	public LinkedList<Objeto> getObjetos() {
		return objetosActivos;
	}
	
	public boolean estaOcupado(Point p){
		
		return (matriz[(int) p.getX()][(int) p.getY()] != null);
		
	}
	
	public boolean hayRalentizador(Enemigo e) {
		return ((e.getPosicion().getX()==OBSTACULO_1.getX() && e.getPosicion().getY()==OBSTACULO_1.getY()) || (e.getPosicion().getX()==OBSTACULO_2.getX() && e.getPosicion().getY()==OBSTACULO_2.getY()));
	}
	
	public void mostrarMatriz(){
		System.out.println("------------------------------------------------");
		for(int i = 0; i< matriz.length; i++) {
			for(int e = 0; e < matriz[0].length; e++) {
				if(matriz[i][e] != null) System.out.print(" 1 ");
				else System.out.print(" 0 ");
				}
			System.out.println(" . ");
		}
	}
}
