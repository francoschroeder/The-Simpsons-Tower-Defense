package Personajes;

import javax.swing.ImageIcon;

import Juego.Enemigo;
import Juego.Personaje;
import Juego.ProyectilEnemigo;

public class Nelson extends Enemigo {
	
	public Nelson() {
		super();
		
		vidaMax = 20;
		vidaActual = vidaMax;
		ataqueOriginal = 7;
		ataque = ataqueOriginal;
		rangoOriginal = 3;
		rango = rangoOriginal;
		velocidadMaxima = 4;
		velocidadActual = velocidadMaxima;
		minMonedas = 10;
		maxMonedas = 15;
		puntos = 75;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/nelson/nelsonNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/nelson/nelsonAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
	
	public Enemigo clone() {
		return new Nelson();
	}
		
}
