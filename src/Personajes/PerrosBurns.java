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
		velocidadMaxima = 10;
		velocidadActual = velocidadMaxima;
		minMonedas = 5;
		maxMonedas = 10;
		puntos = 50;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
	
	public Enemigo clone() {
		return new PerrosBurns();
	}
}
