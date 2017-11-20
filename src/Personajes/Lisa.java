package Personajes;

import javax.swing.ImageIcon;

import Juego.Aliado;
import Juego.Personaje;
import Juego.ProyectilAliado;

public class Lisa extends Aliado {
	
	public Lisa() {
		super();
		
		vidaMax=40;
		vidaActual = vidaMax;
		ataque=15;
		rango=3;
		costo=25;
		miProyectil = new ProyectilAliado(ataque);
		
		imActual.put(Personaje.neutral_key,new ImageIcon(this.getClass().getResource("/sprites/lisa/lisaNeutral.gif")));
		imActual.put(Personaje.shoot_key,new ImageIcon(this.getClass().getResource("/sprites/lisa/lisaAttack.gif")));
	
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
}
