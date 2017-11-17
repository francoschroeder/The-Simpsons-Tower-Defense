package Juego;

import PowerUp.VisitorPowerUp;

public abstract class Aliado extends Comprable {
	
	public Aliado() {
		super();
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
