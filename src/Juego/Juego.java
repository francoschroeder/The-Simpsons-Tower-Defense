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
	private LinkedList<Aliado> aliadosActivos;
	private LinkedList<Enemigo> enemigosActivos;
	private Stack<Personaje> enemigosPorSalir;
	private GUIPrincipal gui;
	
	public Juego(GUIPrincipal p) 
		{// asignar las listas
		this.gui=p;
		aliadosActivos = new LinkedList<Aliado>();
		enemigosActivos = new LinkedList<Enemigo>();
		//enemigosPorSalir = new Stack<Personaje>();
		matriz = new Personaje[10][6];
		tc=75;
	}
	public void agregarPersonaje(Personaje p, Point punto) {
		System.out.println("Posicion del aliado: " + p.getImagen().getLocation().getX());
		matriz[Math.floorDiv((int)punto.getX(), tc)][Math.floorDiv((int)punto.getY(), tc)] = p;
		
		synchronized (aliadosActivos) {
			aliadosActivos.add((Aliado) p);
		}
	}
	
	public Personaje getBlanco(Enemigo p) {
		int y = (int) p.getPosicion().getY();
		int rango = (int) p.getPosicion().getX() + p.getRango();
		
		for(int i =  (int) p.getPosicion().getX(); i <= rango && i<=9; i++){
			
			if (matriz[i][y] != null)
				return matriz[i][y];
		}
		
		return null;	
	}
	
	public Personaje getBlanco(Aliado p) {
		int y = (int) p.getPosicion().getY();
		int rango = (int) p.getPosicion().getX() - p.getRango();
		
		for(int i =  (int) p.getPosicion().getX(); i >= rango && i>=1; i--){
			
			if (matriz[i+1][y] != null)
				return matriz[i][y];
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
			System.out.println("EX: "+(int) (posE.getX()+1)+"EY: "+(int) posE.getY());
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
	
	public LinkedList<Aliado> getAliados() {
		return aliadosActivos;
	}
	
	public boolean estaOcupado(Point p){
		
		return (matriz[(int) p.getX()][(int) p.getY()] != null);
		
	}
	
}
