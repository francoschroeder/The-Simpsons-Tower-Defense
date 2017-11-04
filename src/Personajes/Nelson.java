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
		ataque = 7;
		rango = 3;
		velocidad = 4;
		minMonedas = 2;
		maxMonedas = 4;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/nelson/nelsonNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/nelson/nelsonAttack.gif")));
		
		setImagen(Personaje.neutral_key);
	}
	
	public Enemigo clone() {
		return new Nelson();
	}
		
}
