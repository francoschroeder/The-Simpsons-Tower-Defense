package Personajes;

import javax.swing.ImageIcon;

import Juego.Aliado;
import Juego.Personaje;
import Juego.ProyectilAliado;

public class Marge extends Aliado {
	
	public Marge() {
		super();
		
		vidaMax=160;
		vidaActual = vidaMax;
		ataque=20;
		rango=2;
		costo=10;
		miProyectil = new ProyectilAliado(ataque);
		
		
		this.imActual.put(Personaje.neutral_key,new ImageIcon(this.getClass().getResource("/sprites/marge/margeNeutral.gif")));
		this.imActual.put(Personaje.shoot_key,new ImageIcon(this.getClass().getResource("/sprites/homero/homeroAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}	
	
	@Override
	public int getCantCelda() {
		return 2;
	}
	
}
