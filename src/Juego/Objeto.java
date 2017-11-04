package Juego;

import PowerUp.VisitorPowerUp;

public abstract class Objeto extends Comprable {
	protected int tiempo;
	
	public int serEliminado(){
	return 0;
	}
	
	public void afectar(VisitorPowerUp p) {
		p.afectar(this);
	}
	public Disparo generarDisparo(Personaje p) {
		return new DisparoAliado(new ProyectilAliado(ataque), this, p);
	}
}
