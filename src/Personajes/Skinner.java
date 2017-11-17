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
		ataque=5;
		rango=2;
		velocidadMaxima=2;
		velocidadActual=velocidadMaxima;
		minMonedas= 15;
		maxMonedas= 20;
		puntos = 125;
		miProyectil = new ProyectilEnemigo(ataque);
		
		this.imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerNeutral.gif")));
		this.imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/skinner/skinnerAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
	
	public Enemigo clone() {
		return new Skinner();
	}
}
