package Personajes;

import javax.swing.ImageIcon;

import Juego.Enemigo;
import Juego.Personaje;
import Juego.ProyectilEnemigo;

public class jefeGorgory extends Enemigo {
	
	public jefeGorgory() {
		super();
		
		vidaMax = 10;
		vidaActual = vidaMax;
		ataqueOriginal = 5;
		ataque = ataqueOriginal;
		rangoOriginal = 3;
		rango = rangoOriginal;
		velocidadMaxima = 10;
		velocidadActual = velocidadMaxima;
		minMonedas = 5;
		maxMonedas = 10;
		puntos = 50;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/jefeGorgory/jefeGorgoryNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/jefeGorgory/jefeGorgoryAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
	
	public Enemigo clone() {
		return new jefeGorgory();
	}
}
