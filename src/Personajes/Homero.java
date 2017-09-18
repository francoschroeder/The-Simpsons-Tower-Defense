package Personajes;

import java.awt.Dimension;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Aliado;
import Juego.Personaje;

public class Homero extends Aliado {
	
	public Homero(Point p){	
		posicion = p;
		vidaMax = 25;
		vidaActual = vidaMax;
		ataque = 4;
		rango = 3;
		costo = 10;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/sprites/homero/homeroStill.gif"));
		this.imagen = new JLabel();
		this.imagen.setIcon(img);
		this.imagen.setBounds(188, 85, 75, 75);
		this.imActual = new HashMap<String, Icon>();
		this.imActual.put(Personaje.still_key,new ImageIcon("/sprites/homero/homeroStill.gif"));
	}
	
}
