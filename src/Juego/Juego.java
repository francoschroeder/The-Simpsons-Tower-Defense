package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;

import GUI.FramePrincipal;
import Personajes.*;

public class Juego {
	private Personaje [][] matriz;
	private LinkedList<Personaje> aliadosActivos;
	private LinkedList<Personaje> enemigosActivos;
	private Stack<Personaje> enemigosPorSalir;
	private FramePrincipal gui;
	
	public Juego(FramePrincipal gui) 
		{// asignar las listas
		this.gui=gui;
		//Para probar si se ven los personajes
			Personaje p = new Homero(new Point(1, 2));
			gui.getPanelMapa().add(p.getImagen());
			p.getImagen().setVisible(true);
			
		//Skinner
			Personaje p2 = new Skinner(new Point(2, 1));
			gui.getPanelMapa().add(p2.getImagen());
			p2.getImagen().setVisible(true);
			
			Tiempo t = new Tiempo(p2, gui);
			t.start();
		
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
