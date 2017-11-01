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
		velocidad = 3;
		minMonedas = 3;
		maxMonedas = 6;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/smithers/smithersNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/smithers/smithersAttack.gif")));
		
		setImagen(Personaje.neutral_key);
	}
		
}
