package Personajes;

import javax.swing.ImageIcon;

import Juego.Enemigo;
import Juego.Personaje;
import Juego.ProyectilEnemigo;

public class PerrosBurns extends Enemigo {
	
	public PerrosBurns() {
		super();
		
		vidaMax = 10;
		vidaActual = vidaMax;
		ataque = 5;
		rango = 3;
		velocidad = 10;
		minMonedas = 1;
		maxMonedas = 3;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerAttack.gif")));
		
		setImagen(Personaje.neutral_key);
	}
	
	public Enemigo clone() {
		return new PerrosBurns();
	}
}
