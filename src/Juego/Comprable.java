package Juego;

public abstract class Comprable extends Personaje {
	protected int costo;

	public int getCosto(){
		return costo;
	}
	
	public Disparo generarDisparo(Personaje p) {
		return new DisparoAliado(new ProyectilAliado(ataque), this, p);
	}
}
