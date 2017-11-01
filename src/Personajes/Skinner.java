package Personajes;

import javax.swing.ImageIcon;

import Juego.Enemigo;
import Juego.Personaje;
import Juego.ProyectilEnemigo;

public class Skinner extends Enemigo {
	
	public Skinner() {
		super();
		
		vidaMax=40;
		vidaActual = vidaMax;
		ataque=15;
		rango=2;
		velocidad=2;
		minMonedas=5;
		maxMonedas=8;
		miProyectil = new ProyectilEnemigo(ataque);
		
		this.imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerNeutral.gif")));
		this.imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerAttack.gif")));
		
		setImagen(Personaje.neutral_key);
	}
	
}
