package GUI.Botones;

import java.awt.Point;

import javax.swing.JPanel;

import GUI.PanelMapa;
import Juego.Juego;
import Juego.Personaje;

public class PersoSelec {
	JPanel panel;
	Personaje p;
	Juego j;
	BotonCreacion boton;
	
	public PersoSelec(Juego j){
		p=null;
		this.j = j; 
		boton=null;
	}
	public void setBotonPersonaje(BotonCreacion boton){
		this.boton = boton;
	}
	
	public Personaje getPersonaje(){
		return p;
	}
	
	public void setPanel(JPanel p){ 
		panel = p;
	}
	
	public Personaje generarPersonaje(Point punto){
		Point puntoNuevo = new Point((int)Math.floorDiv((int) punto.getX(), 75),(int)Math.floorDiv((int) punto.getY(), 75));
		this.p = boton.factory();
		panel.add(p.getImagen());
		p.setPosicion(punto);
		j.agregarPersonaje(p, punto);
		return p;
	}
}
