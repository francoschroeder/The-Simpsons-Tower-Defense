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
		velocidad = 2;
		minMonedas = 7;
		maxMonedas = 10;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/bart/jeffNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/bart/jeffAttack.gif")));
		
		setImagen(Personaje.neutral_key);
	}
	
	public Enemigo clone() {
		return new Barney();
	}
}
