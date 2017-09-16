package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;

import GUI.FramePrincipal;
import Personajes.*;

public class Map {
	private Personaje [][] matriz;
	private LinkedList<Personaje> aliadosActivos;
	private LinkedList<Personaje> enemigosActivos;
	private Stack<Personaje> enemigosPorSalir;
	private FramePrincipal gui;
	
	public void generar(FramePrincipal gui) 
		{// asignar las listas
		this.gui=gui;
		
		
	}
	public void agregarPersonaje(String p, int x, int y) {
		p=p.toUpperCase();
		Personaje per = null;
		Point po = new Point(x, y);
		
		if (p.equals("HOMERO")) {
			per = new Homero(po);
		}
		
		matriz[x][y] = per;
	}
	public Personaje getBlanco(Point p, int alcance) {
		return null;
	}
}
