package Juego;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	private Personaje [][] matriz;
	private LinkedList<Comprable> aliadosActivos;
	private LinkedList<Enemigo> enemigosActivos;
	private LinkedList<Objeto> objetosActivos;
	private GUIPrincipal gui;
	private int nivelActual;
	private int vidas;
	private int puntos;
	
	public Juego(GUIPrincipal p) 
		{
		Random rand = new Random();
		OBSTACULO_1 = new Point(rand.nextInt(5), rand.nextInt(9));
		OBSTACULO_2 = new Point(rand.nextInt(5), rand.nextInt(9));
		nivelActual = 1;
		vidas = 3;
		puntos = 0;
		
		// asignar las listas
		this.gui=p;
		gui.modificarNivel(nivelActual);
		gui.modificarVida(vidas);
		gui.modificarPuntos(puntos);
		aliadosActivos =  new LinkedList<Comprable>();
		enemigosActivos =  new LinkedList<Enemigo>();
		objetosActivos = new LinkedList<Objeto>();
		matriz = new Personaje[6][10]; //matriz[fila][columna]
		
		JLabel obst1 = new JLabel();
		obst1.setIcon(new ImageIcon(this.getClass().getResource("/sprites/obstaculos/obstaculo1.png")));
		obst1.setBounds(0, 0, 75, 75);
		gui.getPanelMapa().add(obst1);
		obst1.setLocation((int) OBSTACULO_1.getY()*75, (int) OBSTACULO_1.getX()*75);
		
		JLabel obst2 = new JLabel();
		obst2.setIcon(new ImageIcon(this.getClass().getResource("/sprites/obstaculos/obstaculo2.png")));
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
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		gui.getPanelMapa().add(p.getImagen());
		
		if(p.getCantCelda() != 1) {
			p.getImagen().setLocation((int)p.getPosicion().getY()*75,(int) p.getPosicion().getX()*75);
			matriz[(int)punto.getX()-1][(int)punto.getY()] = p;
		} else {
			p.getImagen().setLocation((int)p.getPosicion().getY()*75,(int) p.getPosicion().getX()*75);
		}
		
		mostrarMatriz();
		p.actualizarVida();
		gui.getPanelMapa().add(p.getBarraDeVida());
		p.getImagen().setVisible(true);
		p.getBarraDeVida().setVisible(true);
		synchronized (aliadosActivos) {aliadosActivos.add(p);}
		gui.actualizarCartel();
		gui.getPanelMapa().validate();
		gui.getPanelMapa().repaint();
	}
	
	public void agregarPersonaje(Objeto o, Point punto) {
		
		gui.getPanelMapa().add(o.getImagen());
		o.getImagen().setLocation((int)(punto.getY())*75,(int)(punto.getX())* 75);
		matriz[(int)punto.getX()][(int)punto.getY()] = o;
		o.getImagen().setVisible(true);
		synchronized (objetosActivos) {objetosActivos.add(o);}
		gui.actualizarCartel();
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
		puntos += p.getPuntos();
		gui.modificarPuntos(puntos);
		double x = Math.random();
		
		HashMap<Integer,PowerUp> mapeoPowerUp = new HashMap<Integer,PowerUp>();
		mapeoPowerUp.put(0, new Bomba());	
		mapeoPowerUp.put(1, new Curacion());
		mapeoPowerUp.put(2, new MagiaAlcance());
		mapeoPowerUp.put(3, new MagiaAtaque());
		
		//15% de posibilidades de generar powerUp
		//Bomba, curacion, magia alcance, magia ataque
		
		if (x<=0.20){ 	
			
			Random generator = new Random();
			PowerUp  agregar = mapeoPowerUp.get(generator.nextInt(mapeoPowerUp.size()));
			agregar = agregar.clone();
			agregar.addActionListener(new OyenteBoton( agregar));
			
			gui.getPanelMapa().add(agregar);
			agregar.setBounds((int)p.getImagen().getLocation().getX(),(int) p.getImagen().getLocation().getY(),75,75);
			agregar.setVisible(true);
			agregar.setOpaque(false);
			agregar.setContentAreaFilled(false);
			agregar.setBorderPainted(false);
			
		
		}		
	}
	
	private class OyenteBoton implements ActionListener{
		PowerUp p;

		public OyenteBoton(PowerUp p){
			this.p = p;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			aplicarPowerUp(p.factory());
			gui.getPanelMapa().remove(p);
			gui.getPanelMapa().validate();
			gui.getPanelMapa().repaint();
		}
	}
	
	public void aplicarPowerUp(VisitorPowerUp p) {
		for(Enemigo e  : enemigosActivos ) {
			e.afectar(p);
		}
		
		for(Comprable a : aliadosActivos) {
			a.afectar(p);
		}
	}
	public void eliminar(Comprable p) {
		gui.getPanelMapa().remove(p.getImagen());
		gui.getPanelMapa().validate();
		gui.getPanelMapa().repaint();
		synchronized (aliadosActivos) {aliadosActivos.remove(p);}
		matriz[(int) p.getPosicion().getX()][(int) p.getPosicion().getY()] = null;
		
		if (p.getCantCelda()!=1) {
			matriz[(int) p.getPosicion().getX()-1][(int) p.getPosicion().getY()] = null;
		}
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
	
	public boolean estaOcupado(Comprable c, Point p){
		if (c.getCantCelda()!=1) {
			if (p.getX()==0)
				return true;
			else
				return ((matriz[(int) p.getX()][(int) p.getY()] != null) && (matriz[(int) p.getX()-1][(int) p.getY()]!=null)); 
		}
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
	
	public void pasarDeNivel() {
		nivelActual++;
		gui.modificarNivel(nivelActual);
	}
	
	public boolean perdio() {
		return vidas==0;
	}
	
	public void restarVidas() {
		vidas--;
		gui.modificarVida(vidas);
	}
}
