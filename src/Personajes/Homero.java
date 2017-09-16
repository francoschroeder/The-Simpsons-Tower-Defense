package Personajes;

import java.awt.Dimension;
import java.awt.Point;
import javax.swing.ImageIcon;
import Juego.Aliado;
import Juego.Personaje;

public class Homero extends Aliado {
	int vidaMax = 25;
	int ataque = 4;
	int rango = 3;
	int costo = 10;	
	
	public Homero(Point p){	
		posicion = p;
		vidaActual = vidaMax;
		this.imActual.put(Personaje.still_key,new ImageIcon(this.getClass().getResource("/sprites/Homero/homero.png")));
	}
	
}
