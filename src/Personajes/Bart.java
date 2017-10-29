package Personajes;

import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Aliado;
import Juego.Personaje;

public class Bart extends Aliado {
	
	public Bart(){
		posicion=null;
		vidaMax=20;
		ataque=5;
		rango=3;
		costo=10;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/sprites/bart/bartStill.gif"));
		
		this.imagen = new JLabel();
		this.imagen.setIcon(img);
		this.imagen.setBounds(0, 0, 75, 75);
		
		this.imActual = new HashMap<String, ImageIcon>();
		this.imActual.put(Personaje.still_key,new ImageIcon("/sprites/bart/bartStill.gif"));
		this.imActual.put(Personaje.shoot_key,new ImageIcon("/sprites/bart/bartAttack.gif"));

	
	}
	}
