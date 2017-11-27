package Personajes;

import javax.swing.ImageIcon;

import Juego.Aliado;
import Juego.Personaje;
import Juego.ProyectilAliado;

public class Homero extends Aliado {
	
	public Homero(){	
		super();
		
		vidaMax = 30;
		vidaActual = vidaMax;
		ataqueOriginal = 20;
		ataque = ataqueOriginal;
		rangoOriginal = 3;
		rango = rangoOriginal;
		costo = 30;
		miProyectil = new ProyectilAliado(ataque);
		
		imActual.put(Personaje.neutral_key,new ImageIcon(this.getClass().getResource("/sprites/homero/homeroNeutral.gif")));
		imActual.put(Personaje.shoot_key,new ImageIcon(this.getClass().getResource("/sprites/homero/homeroAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}
	
}
