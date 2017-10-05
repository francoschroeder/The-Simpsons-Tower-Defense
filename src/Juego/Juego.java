package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;


import GUI.GUIPrincipal;
import Personajes.*;

public class Juego {
	private int tc;
	private Personaje [][] matriz;
	private LinkedList<Personaje> aliadosActivos;
	private LinkedList<Personaje> enemigosActivos;
	private Stack<Personaje> enemigosPorSalir;
	private GUIPrincipal gui;
	
	public Juego(GUIPrincipal gui) 
		{// asignar las listas
		this.gui=gui;
		aliadosActivos = new LinkedList<Personaje>();
		enemigosActivos = new LinkedList<Personaje>();
		enemigosPorSalir = new Stack<Personaje>();
		matriz = new Personaje[10][6];
		tc=75;
	}
	public void agregarPersonaje(Personaje p, Point punto) {
		
		matriz[Math.floorDiv((int)punto.getX(), tc)][Math.floorDiv((int)punto.getY(), tc)] = p;
		
	}
	
	public Personaje getBlanco(Point p, int alcance) {
		return null;
	}
	
	

	
	public void eliminar() {
		enemigosActivos.remove(matriz[2][1]);
		matriz[2][1].getImagen().setVisible(false);
		matriz[2][1] = null;
	}
	
}
