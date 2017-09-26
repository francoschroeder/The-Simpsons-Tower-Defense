package Personajes;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Enemigo;
import Juego.Personaje;

public class Skinner extends Enemigo {
	
	public Skinner(Point p) {
		vidaMax=40;
		vidaActual = vidaMax;
		ataque=15;
		rango=4;
		velocidad=2.5f;
		minMonedas=5;
		maxMonedas=8;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerWalk.gif"));
		
		this.imagen = new JLabel();
		this.imagen.setIcon(img);
		this.imagen.setBounds(178, 75, 75, 75);
		
		this.imActual = new HashMap<String, Icon>();
		this.imActual.put(Enemigo.forward_key, new ImageIcon("/sprites/skinner/skinnerWalk.gif"));
		this.imActual.put(Personaje.shoot_key, new ImageIcon("/sprites/skinner/skinnerAttack.gif"));
	}
	
}
