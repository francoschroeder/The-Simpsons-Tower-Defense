package Personajes;

import javax.swing.ImageIcon;

import Juego.Enemigo;
import Juego.Personaje;
import Juego.ProyectilEnemigo;

public class Barney extends Enemigo {

	public Barney() {
		super();
		
		vidaMax = 50;
		vidaActual = vidaMax;
		ataque = 20;
		rango = 4;
		velocidadMaxima = 2;
		velocidadActual = velocidadMaxima;
		minMonedas = 7;
		maxMonedas = 10;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/barney/barneyNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/barney/barneyAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
	
	public Enemigo clone() {
		return new Barney();
	}
}
