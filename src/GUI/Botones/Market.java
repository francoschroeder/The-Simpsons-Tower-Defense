package GUI.Botones;

import java.awt.Point;

import javax.swing.JPanel;

import GUI.PanelMapa;
import Juego.Juego;
import Juego.Personaje;

public class Market {
	JPanel panel;
	Personaje p;
	Juego j;
	BotonCreacion boton;
	
	public Market(Juego j){
		p=null;
		this.j = j; 
		boton=null;
	}
	public void setBotonPersonaje(BotonCreacion boton){
		System.out.println("seteo el factory");
		this.boton = boton;
	}
	
	public Personaje getPersonaje(){
		return p;
	}
	
	public void setPanel(JPanel p){ 
		System.out.println("agrege panel al market");
		panel = p;
	}
	
	public Personaje generarPersonaje(Point punto){
		System.out.println("Entro a generar personaje");
		Point puntoNuevo = new Point((int)Math.floorDiv((int) punto.getX(), 75),(int)Math.floorDiv((int) punto.getY(), 75));
		System.out.println((int)Math.floorDiv((int) punto.getX(), 75));
		System.out.println((int)Math.floorDiv((int) punto.getY(), 75));
		this.p = boton.factory();
		panel.add(p.getImagen());
		p.setPosicion(puntoNuevo);
		j.agregarPersonaje(p, punto);
		return p;
	}
}
