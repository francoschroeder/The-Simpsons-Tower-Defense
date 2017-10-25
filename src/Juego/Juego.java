package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;


import GUI.GUIPrincipal;
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
		
		matriz[Math.floorDiv((int)punto.getX(), tc)][Math.floorDiv((int)punto.getY(), tc)] = p;
		
	}
	
	public Personaje getBlanco(Personaje p) {
		
		int y = (int) p.getPosicion().getY();
		
		for(int i =  (int) p.getPosicion().getX(); i <= i+ p.getRango(); i++){
			
			if (matriz[i][y] != null)
				return matriz[i][y];
		}
		
		return null;
		
	}
	
	
	/*Avanza el enemigo 1 cuadro hacia adelante
	 * Retorna true si se pudo avanzar (si no hay nadie en frente) y false en caso contrario
	 */
	public boolean moverEnemigo(Enemigo e) {
		Point posE = e.getPosicion();
		
		if (matriz[((int) posE.getX())+1][(int) posE.getY()] == null) {
			matriz[((int) posE.getX())+1][(int) posE.getY()] = matriz[(int) posE.getX()][(int) posE.getY()];
			matriz[(int) posE.getX()][(int) posE.getY()] = null;
			return true;
		}
			
		return false;
	}
	
	
	public void eliminar() {
		enemigosActivos.remove(matriz[2][1]);
		matriz[2][1].getImagen().setVisible(false);
		matriz[2][1] = null;
	}
	
	public LinkedList getEnemigos() {
		return enemigosActivos;
	}
	
}
