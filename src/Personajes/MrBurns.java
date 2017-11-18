package Personajes;

import javax.swing.ImageIcon;

import Juego.Enemigo;
import Juego.Personaje;
import Juego.ProyectilEnemigo;

public class MrBurns extends Enemigo { 
	
	public MrBurns() {
		super();
		
		vidaMax = 60;
		vidaActual = vidaMax;
		ataque = 25;
		rango = 5;
		velocidadMaxima = 1;
		velocidadActual = velocidadMaxima;
		minMonedas = 12;
		maxMonedas = 15;
		puntos = 200;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/burns/burns.png")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/burns/burns.png")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
	
	public Enemigo clone() {
		return new MrBurns();
	}
	
}
