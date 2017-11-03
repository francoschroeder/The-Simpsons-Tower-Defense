
package GUI.Botones;

import java.awt.Point;

import javax.swing.JPanel;

import GUI.PanelMapa;
import Juego.Juego;
import Juego.Personaje;
import Juego.Aliado;
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
	}
	public void setBotonPersonaje(BotonCreacion boton){
		System.out.println("seteo el factory");
		this.boton = boton;
	}
	
	public Comprable getPersonaje(){
		return p;
	}
	
	public void setPanel(JPanel p){ 
		System.out.println("agrege panel al market");
		panel = p;
	}
	
	public void sumarMonedas(int m){
		monedas+=m;
	}
	
	
	public void generarPersonaje(Point punto){
		if(boton != null) {
		Point puntoNuevo = new Point((int)Math.floorDiv((int) punto.getY(), 75),(int)Math.floorDiv((int) punto.getX(), 75));
		this.p = boton.factory();
		if (!j.estaOcupado(puntoNuevo))
			{ 
			j.agregarPersonaje(p, puntoNuevo);
			boton = null;
			}
		}
		
	}
}

