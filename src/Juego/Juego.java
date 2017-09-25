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
			
			
		//Skinner
			
			
			
		
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
	
	public void CrearHomero(){
		Personaje p = new Homero(new Point(1, 2));
		matriz[1][2] = p;
		aliadosActivos.add(p);
		
		gui.getPanelMapa().add(p.getImagen());
		p.getImagen().setVisible(true);
	}
	
	public void CrearSkinner(){
		Personaje p2 = new Skinner(new Point(2, 1));
		matriz[2][1] = p2;
		enemigosActivos.add(p2);
		
		gui.getPanelMapa().add(p2.getImagen());
		p2.getImagen().setVisible(true);
	}
	
	public void eliminar() {
		enemigosActivos.remove(matriz[2][1]);
		matriz[2][1].getImagen().setVisible(false);
		gui.getPanelMapa().remove(matriz[2][1].getImagen());
		gui.getPanelMapa().revalidate();
		gui.getPanelMapa().repaint();
		matriz[2][1] = null;
	}
	
}
