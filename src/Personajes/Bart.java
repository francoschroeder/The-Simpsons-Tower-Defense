package Personajes;

import javax.swing.ImageIcon;

import Juego.Aliado;
import Juego.Personaje;
import Juego.ProyectilAliado;

public class Bart extends Aliado {
	
	public Bart(){
		super();
		
		vidaMax=20;
		vidaActual = vidaMax;
		ataque=10;
		rango=3;
		costo=10;
		miProyectil = new ProyectilAliado(ataque);
		
		imActual.put(Personaje.neutral_key,new ImageIcon(this.getClass().getResource("/sprites/bart/bartNeutral.gif")));
		imActual.put(Personaje.shoot_key,new ImageIcon(this.getClass().getResource("/sprites/bart/bartAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
}
