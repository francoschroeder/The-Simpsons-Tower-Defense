package Juego;

public abstract class Proyectil {
	protected int ataque;
	
	public abstract void atacarAliado(Aliado a);
	
	public abstract void atacarEnemigo(Enemigo e);
	
	public abstract void atacarObjeto(Objecto o);
}
