
package GUI.Botones;

import java.awt.Point;

import javax.swing.JPanel;

import GUI.PanelMapa;
import Juego.Juego;
import Juego.Personaje;
import Juego.Aliado;

public class Market {
	JPanel panel;
	Personaje p;
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
	
	public Personaje getPersonaje(){
		return p;
	}
	
	public void setPanel(JPanel p){ 
		System.out.println("agrege panel al market");
		panel = p;
	}
	
	public void sumarMonedas(int m){
		monedas+=m;
	}
	
	
	public Personaje generarPersonaje(Point punto){
		Point puntoNuevo = new Point((int)Math.floorDiv((int) punto.getX(), 75),(int)Math.floorDiv((int) punto.getY(), 75));
		System.out.println("X:"+(int) puntoNuevo.getX()+"Y: "+ (int)puntoNuevo.getY());
		this.p = boton.factory();
		if (! j.estaOcupado(puntoNuevo)){ panel.add(p.getImagen());
			p.setPosicion(puntoNuevo);
			j.agregarPersonaje(p, puntoNuevo);
			//CORREGIR
			synchronized (j.getAliados()){j.getAliados().add((Aliado) p);} 
			}
		return p;
	}
}

