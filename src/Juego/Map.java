package Juego;

import java.util.LinkedList;
import java.util.Stack;

import GUI.FramePrincipal;

public class Map {
	private Personaje [][] matriz;
	private LinkedList<Personaje> AliadosActivos;
	private LinkedList<Personaje> EnemigosActivos;
	private Stack<Personaje> EnemigosPorSalir;
	private FramePrincipal gui;
	
	public void generar(FramePrincipal gui) 
		{// asignar las listas
		this.gui=gui;
		
		
	}
	public void agregarPersonaje(){
		
	}
	public Personaje getBlanco(int x, int y, int alcance) {
		return null;
	}
}
