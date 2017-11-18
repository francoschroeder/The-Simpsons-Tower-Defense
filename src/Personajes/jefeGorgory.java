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
		ataque = 5;
		rango = 3;
		velocidadMaxima = 10;
		velocidadActual = velocidadMaxima;
		minMonedas = 5;
		maxMonedas = 10;
		puntos = 50;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/jefeGorgory/22.png")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/jefeGorgory/23.png")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
	
	public Enemigo clone() {
		return new jefeGorgory();
	}
}
