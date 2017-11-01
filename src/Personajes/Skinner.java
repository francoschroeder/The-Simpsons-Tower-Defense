package Personajes;
import java.awt.Point;
import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Enemigo;
import Juego.Personaje;

public class Skinner extends Enemigo {
	
	public Skinner() {
		posicion=null;
		vidaMax=40;
		vidaActual = vidaMax;
		ataque=15;
		rango=4;
		velocidad=2;
		minMonedas=5;
		maxMonedas=8;
		
		ImageIcon img = new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerWalk.gif"));
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/sprites/vida.png"));
		
		this.imagen = new JLabel();
		this.imagen.setIcon(img);
		this.imagen.setBounds(0, 0, 75, 75);
		
		this.barraDeVida = new JLabel();
		this.barraDeVida.setIcon(img2);
		this.actualizarVida();
		
		this.imActual = new HashMap<String, ImageIcon>();
		this.imActual.put(Enemigo.forward_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerWalk.gif")));
		this.imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerAttack.gif")));
	}
	
}
