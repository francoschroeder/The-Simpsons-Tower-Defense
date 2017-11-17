package Juego;

import PowerUp.VisitorPowerUp;

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
	
	public void afectar(VisitorPowerUp p) {
		p.afectar(this);
	}
	
	public Disparo generarDisparo(Personaje p) {
		return new DisparoAliado(miProyectil, this, p);
	}
}
