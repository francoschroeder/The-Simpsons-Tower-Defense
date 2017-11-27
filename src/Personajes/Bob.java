package Personajes;

import javax.swing.ImageIcon;

import Juego.Enemigo;
import Juego.Personaje;
import Juego.ProyectilEnemigo;

public class Bob extends Enemigo {
	
	public Bob() {
		super();
		
		vidaMax = 30;
		vidaActual = vidaMax;
		ataqueOriginal = 10;
		ataque = ataqueOriginal;
		rangoOriginal = 3;
		rango = rangoOriginal;
		velocidadMaxima = 3;
		velocidadActual = velocidadMaxima;
		minMonedas = 10;
		maxMonedas = 14;
		puntos = 100;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/bob/bobNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/bob/bobAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
		public Enemigo clone() {
			return new Bob();
		}
}
