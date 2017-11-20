package Personajes;

import javax.swing.ImageIcon;

import Juego.Enemigo;
import Juego.Personaje;
import Juego.ProyectilEnemigo;

public class Smithers extends Enemigo {
	
	public Smithers() {
		super();
		
		vidaMax = 30;
		vidaActual = vidaMax;
		ataque = 10;
		rango = 3;	
		velocidadMaxima = 3;
		velocidadActual = velocidadMaxima;
		minMonedas = 10;
		maxMonedas = 14;
		puntos = 100;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
		public Enemigo clone() {
			return new Smithers();
		}
}
