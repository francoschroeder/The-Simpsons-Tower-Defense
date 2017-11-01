package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;


import GUI.GUIPrincipal;
import GUI.PanelMapa;
import Personajes.*;

public class Juego {
	private int tc;
	private Personaje [][] matriz;
	private LinkedList<Comprable> aliadosActivos;
	private LinkedList<Enemigo> enemigosActivos;
	private Stack<Personaje> enemigosPorSalir;
	private GUIPrincipal gui;
	
	public Juego(GUIPrincipal p) 
		{// asignar las listas
		this.gui=p;
		aliadosActivos = new LinkedList<Comprable>();
		enemigosActivos = new LinkedList<Enemigo>();
		//enemigosPorSalir = new Stack<Personaje>();
		matriz = new Personaje[10][6];
		tc=75;
	}
	
	public void agregarPersonaje(Enemigo p, Point punto) {
		System.out.println("Posicion del aliado: " + p.getImagen().getLocation().getX());
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		p.getImagen().setBounds((int)punto.getX()*75,(int)punto.getY()* 75,tc,tc);
		p.actualizarVida();
		gui.getPanelMapa().add(p.getImagen());
		gui.getPanelMapa().add(p.getBarraDeVida());
		p.getImagen().setVisible(true);
		p.getBarraDeVida().setVisible(true);
		synchronized (enemigosActivos) {enemigosActivos.add(p);}
	}
	
	public void agregarPersonaje(Comprable p, Point punto) {
		System.out.println("Posicion del aliado: " + p.getImagen().getLocation().getX());
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		synchronized (enemigosActivos) {aliadosActivos.add(p);}
	}
	
	
	
	public Personaje getBlanco(Enemigo p) {
		int y = (int) p.getPosicion().getY();
		int rango = (int) p.getPosicion().getX() + p.getRango();
		
		for(int i =  (int) p.getPosicion().getX(); i <= rango && i<=8; i++){
			
			if (matriz[i+1][y] != null)
				return matriz[i+1][y];
		}
		
		return null;	
	}
	
	public Personaje getBlanco(Comprable p) {
		int y = (int) p.getPosicion().getY();
		int rango = (int) p.getPosicion().getX() - p.getRango();
		
		for(int i =  (int) p.getPosicion().getX(); i >= rango && i>=1; i--){
			
			if (matriz[i-1][y] != null)
				return matriz[i-1][y];
		}
		
		return null;
	}
	
	
	/*Avanza el enemigo 1 cuadro hacia adelante
	 * Retorna true si se pudo avanzar (si no hay nadie en frente) y false en caso contrario
	 */
	public boolean moverEnemigo(Enemigo e) {
		Point posE = e.getPosicion();
		
		if (((int) posE.getX() != 9) && (matriz[((int) posE.getX())+1][(int) posE.getY()] == null)) {
			matriz[((int) posE.getX())+1][(int) posE.getY()] = matriz[(int) posE.getX()][(int) posE.getY()];
			matriz[(int) posE.getX()][(int) posE.getY()] = null;
			e.setPosicion(new Point((int)( posE.getX())+1, (int) posE.getY()));
			return true;
			
		}
			
		return false;
	}
	
	
	public void eliminar(Personaje p) {
		gui.getPanelMapa().remove(p.getImagen());
		enemigosActivos.remove(p);
		matriz[(int) p.getPosicion().getX()][(int) p.getPosicion().getY()] = null;
		gui.getMarket().sumarMonedas(p.serEliminado());
		
	}
	
	public LinkedList<Enemigo> getEnemigos() {
		return enemigosActivos;
	}
	
	public LinkedList<Comprable> getAliados() {
		return aliadosActivos;
	}
	
	public boolean estaOcupado(Point p){
		
		return (matriz[(int) p.getX()][(int) p.getY()] != null);
		
	}
	
}
