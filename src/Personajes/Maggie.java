package Personajes;

import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Aliado;
import Juego.Personaje;

public class Maggie extends Aliado {
	
	public Maggie(){
		posicion = null;
		vidaActual = vidaMax;
		vidaMax=100;
		ataque=35;
		rango=3;
		costo=100;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/sprites/maggie/caminar.gif"));
		
		this.imagen = new JLabel();
		this.imagen.setIcon(img);
		this.imagen.setBounds(0, 0, 75, 75);
		
		this.imActual = new HashMap<String, Icon>();
		this.imActual.put(Personaje.still_key,new ImageIcon("/sprites/maggie/caminar.gif"));
		this.imActual.put(Personaje.shoot_key,new ImageIcon("/sprites/homero/homeroAttack.gif"));

	}
}

