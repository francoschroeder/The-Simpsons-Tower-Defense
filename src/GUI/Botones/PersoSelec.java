package GUI.Botones;

import java.awt.Point;

import Juego.Juego;
import Juego.Personaje;

public class PersoSelec {
	Personaje p;
	Juego j;
	BotonCreacion boton;
	
	public PersoSelec(Juego j){
		p=null;
		this.j = j; 
		boton=null;
	}
	public void serPersonaje(BotonCreacion boton){
		this.boton = boton;
	}
	
	public Personaje getPersonaje(){
		return p;
	}
	public Personaje generarPersonaje(Point punto){
		this.p = boton.factory();
		punto = new Point(75,75);
		p.setPosicion(punto);
		j.agregarPersonaje(p, (int) Math.floor(punto.getX()/75),(int) Math.floor(punto.getY()/75));
		return p;
	}
}
