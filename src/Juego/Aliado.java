package Juego;

public abstract class Aliado extends Comprable {
	protected int costo; 
	
	public Aliado() {
		super();
	}
	
	public int getCosto() {
		return costo;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarAliado(this);
	}
	
	public int serEliminado(){
		return 0;
	}
	
	public Disparo generarDisparo(Personaje p) {
		return new DisparoAliado(miProyectil, this, p);
	}
}
