package Juego;
import Juego.Objeto;

import javax.swing.JLabel;

public abstract class Proyectil{
	protected int ataque;
	
	protected JLabel imagen;
	
	public abstract void atacarAliado(Aliado a);
	
	public abstract void atacarEnemigo(Enemigo e);
	
	public abstract void atacarObjeto(Objeto o);
}
