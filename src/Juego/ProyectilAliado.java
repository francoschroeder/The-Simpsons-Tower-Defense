package Juego;

import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ProyectilAliado extends Proyectil {
	
	public ProyectilAliado(int a) {
		ataque = a;
	}
	
	public void atacarAliado(Aliado a) {}
	
	public void atacarEnemigo(Enemigo e) {
		e.reducirVida(ataque);
	}
	
	public void atacarObjeto(Objeto o) {
		o.reducirVida(ataque);
	}
	
	
}
