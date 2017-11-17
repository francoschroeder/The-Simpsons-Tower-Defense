
package GUI.Botones;

import java.awt.Point;

import javax.swing.JPanel;

import Juego.Juego;
import Juego.Comprable;

public class Market {
	JPanel panel;
	Comprable p;
	Juego j;
	BotonCreacion boton;
	int monedas;
	
	public Market(Juego j){
		p=null;
		this.j = j; 
		boton=null;
		monedas = 100;
	}
	
	public int getMonedas(){
		return monedas;
	}
	
	public void setBotonPersonaje(BotonCreacion boton){
		this.boton = boton;
	}
	
    	public Comprable getPersonaje(){
		return p;
	}
	
	public void setPanel(JPanel p){ 
		panel = p;
	}
	
	public void sumarMonedas(int m){
		monedas+=m;
	}
	
	public void restarMonedas(int m){
		monedas-=m;
	}
	
	
	public void generarPersonaje(Point punto){
		if(boton != null) {
			this.p = boton.factory();
			Point puntoNuevo = new Point((int)Math.floorDiv((int) punto.getY(), 75),(int)Math.floorDiv((int) punto.getX(), 75));
			if(!j.estaOcupado(p, puntoNuevo)){ 
				if(monedas >= p.getCosto()) {
					restarMonedas(p.getCosto());
					j.agregarPersonaje(p, puntoNuevo);
					boton = null;
				}
			}
		}		
	}

	
}

