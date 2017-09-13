package Juego;

public abstract class Personaje {
	protected int vidaMax;
	protected int ataque;
	protected int rango;
	
	public void atacar(Personaje p) {}
	
	public void reducirVida(int i) {
		vidaMax-=i;
	}
	
}
