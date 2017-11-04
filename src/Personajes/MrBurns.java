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
		velocidad = 1;
		minMonedas = 12;
		maxMonedas = 15;
		miProyectil = new ProyectilEnemigo(ataque);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/mrburns/mrburnsNeutral.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/mrburns/mrburnsAttack.gif")));
		
		setImagen(Personaje.neutral_key);
	}
	
	public Enemigo clone() {
		return new MrBurns();
	}
	
}
