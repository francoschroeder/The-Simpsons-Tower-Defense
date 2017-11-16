package Juego;

import PowerUp.VisitorPowerUp;

public abstract class Objeto extends Comprable {
	
	public void afectar(VisitorPowerUp p) {
		p.afectar(this);
	}
	public Disparo generarDisparo(Personaje p) {
		return new DisparoAliado(new ProyectilAliado(ataque), this, p);
	}
}
