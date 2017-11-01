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
	private GUIPrincipal gui;
	
	public Juego(GUIPrincipal p) 
		{
		// asignar las listas
		this.gui=p;
		aliadosActivos = new LinkedList<Comprable>();
		enemigosActivos = new LinkedList<Enemigo>();
		matriz = new Personaje[6][10]; //matriz[fila][columna]
		tc=75;
	
		
		
		}
	
	public void agregarPersonaje(Enemigo p, Point punto) {
		System.out.println("Posicion del aliado: " + p.getImagen().getLocation().getX());
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		p.getImagen().setBounds((int)(punto.getY())*75,(int)(punto.getX())* 75,tc,tc);
		p.actualizarVida();
		gui.getPanelMapa().add(p.getImagen());
		gui.getPanelMapa().add(p.getBarraDeVida());
		p.getImagen().setVisible(true);
		p.getBarraDeVida().setVisible(true);
		synchronized (enemigosActivos) {enemigosActivos.add(p);}
	}
	
	public void agregarPersonaje(Comprable p, Point punto) {
		System.out.println("Posicion del Comprado: " + p.getImagen().getLocation().getX());
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		mostrarMatriz();
		p.getImagen().setBounds((int)(punto.getX())*75,(int)(punto.getY())* 75,tc,tc);
		p.actualizarVida();
		gui.getPanelMapa().add(p.getImagen());
		gui.getPanelMapa().add(p.getBarraDeVida());
		p.getImagen().setVisible(true);
		p.getBarraDeVida().setVisible(true);
		synchronized (aliadosActivos) {aliadosActivos.add(p);}
		p.setPosicion(punto);
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
			this.mostrarMatriz();
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
}
