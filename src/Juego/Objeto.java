package Juego;

public abstract class Objeto extends Comprable {
	protected int tiempo;
	
	public int serEliminado(){
	return 0;
	}
	public Disparo generarDisparo(Personaje p) {
		return new DisparoAliado(new ProyectilAliado(ataque), this, p);
	}
}
