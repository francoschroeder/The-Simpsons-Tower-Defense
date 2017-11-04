package Juego;

import java.awt.Point;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;
import java.util.List;


import GUI.GUIPrincipal;
import GUI.PanelMapa;
import Personajes.*;

public class Juego {
	private int tc;
	private Personaje [][] matriz;
	private List<Comprable> aliadosActivos;
	private List<Enemigo> enemigosActivos;
	private List<Objeto> objetosActivos;
	private GUIPrincipal gui;
	
	public Juego(GUIPrincipal p) 
		{
		// asignar las listas
		this.gui=p;
		aliadosActivos =  new LinkedList<Comprable>();
		enemigosActivos =  new LinkedList<Enemigo>();
		objetosActivos = new LinkedList<Objeto>();
		matriz = new Personaje[6][10]; //matriz[fila][columna]
		tc=75;
		}
	
	public void agregarPersonaje(Enemigo p, Point punto) {
		
		gui.getPanelMapa().add(p.getImagen());
		p.getImagen().setLocation((int)(punto.getY())*75,(int)(punto.getX())* 75);
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		p.actualizarVida();
		gui.getPanelMapa().add(p.getBarraDeVida());
		p.getImagen().setVisible(true);
		p.getBarraDeVida().setVisible(true);
		synchronized (enemigosActivos) {enemigosActivos.add(p);}
	}
	
	public void agregarPersonaje(Comprable p, Point punto) {
		p.setPosicion(punto);
		gui.getPanelMapa().add(p.getImagen());
		p.getImagen().setLocation((int)p.getPosicion().getY()*75,(int) p.getPosicion().getX()*75);;
		matriz[(int)punto.getX()][(int)punto.getY()] = p;
		mostrarMatriz();
		p.actualizarVida();
		gui.getPanelMapa().add(p.getBarraDeVida());
		p.getImagen().setVisible(true);
		p.getBarraDeVida().setVisible(true);
		synchronized (aliadosActivos) {aliadosActivos.add(p);}
	}
	
	public void agregarPersonaje(Objeto o, Point punto) {
		
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
			e.getImagen().setLocation((int) e.getPosicion().getY()*75, (int) e.getPosicion().getX()*75);
			this.mostrarMatriz();
			return true;
			
		}
			
		return false;
	}
	
	
	public void eliminar(Enemigo p) {
		gui.getPanelMapa().remove(p.getImagen());
		synchronized (enemigosActivos) {enemigosActivos.remove(p);}
		matriz[(int) p.getPosicion().getX()][(int) p.getPosicion().getY()] = null;
		gui.getMarket().sumarMonedas(p.serEliminado());
		
	}
	
	public void eliminar(Comprable p) {
		gui.getPanelMapa().remove(p.getImagen());
		synchronized (aliadosActivos) {aliadosActivos.remove(p);}
		matriz[(int) p.getPosicion().getX()][(int) p.getPosicion().getY()] = null;
	}
	
	public void eliminar(Objeto o) {
		gui.getPanelMapa().remove(o.getImagen());
		synchronized (objetosActivos) {objetosActivos.remove(o);}
		matriz[(int) o.getPosicion().getX()][(int) o.getPosicion().getY()] = null;
	}
	
	public List<Enemigo> getEnemigos() {
		return enemigosActivos;
	}
	
	public List<Comprable> getAliados() {
		return aliadosActivos;
	}
	
	public List<Objeto> getObjetos() {
		return objetosActivos;
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
