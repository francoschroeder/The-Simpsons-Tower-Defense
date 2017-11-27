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
		ataqueOriginal=20;
		ataque=ataqueOriginal;
		rangoOriginal=2;
		rango=rangoOriginal;
		costo=40;
		imagen.setBounds(0, 0, 150, 75);
		miProyectil = new ProyectilAliado(ataque);
		
		
		this.imActual.put(Personaje.neutral_key,new ImageIcon(this.getClass().getResource("/sprites/marge/MargeNeutral.gif")));
		this.imActual.put(Personaje.shoot_key,new ImageIcon(this.getClass().getResource("/sprites/marge/MargeAttack.gif")));
		
		setImagen(Personaje.neutral_key);
		actualizarVida();
	}	
	
	@Override
	public int getCantCelda() {
		return 2;
	}
	
}
