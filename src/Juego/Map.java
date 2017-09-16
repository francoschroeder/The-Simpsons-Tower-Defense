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
	public void agregarPersonaje(String p, Point po) {
		p=p.toUpperCase();
		Personaje per = null;
		
		if (p.equals("HOMERO")) {
			per = new Homero();
		}
		
		matriz[(int) po.getX()][(int) po.getY()] = per;
		
	}
	public Personaje getBlanco(Point p, int alcance) {
		return null;
	}
}
