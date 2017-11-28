package Juego;

public abstract class State {
	public abstract void reducirVida(int v);
	
	public abstract void setCampoDeProteccion();
}
