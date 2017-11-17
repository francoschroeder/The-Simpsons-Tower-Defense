package Personajes;

import javax.swing.ImageIcon;

import Juego.Aliado;
import Juego.Personaje;
import Juego.ProyectilAliado;

public class Maggie extends Aliado {
	
	public Maggie(){
		super();
		
		vidaMax=100;
		vidaActual = vidaMax;
		ataque=35;
		rango=3;
		costo=60;
		miProyectil = new ProyectilAliado(ataque);
		
		imActual.put(Personaje.neutral_key,new ImageIcon(this.getClass().getResource("/sprites/maggie/maggieNeutral.gif")));
		imActual.put(Personaje.shoot_key,new ImageIcon(this.getClass().getResource("/sprites/maggie/maggieAtaque.gif")));

		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
}

