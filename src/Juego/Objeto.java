package Juego;

import PowerUp.VisitorPowerUp;

public abstract class Objeto extends Comprable {
	
	public void afectar(VisitorPowerUp p) {
		p.afectar(this);
	}
	public Disparo generarDisparo(Personaje p) {
		return new DisparoAliado(new ProyectilAliado(ataque), this, p);
	}
	
	//Acumula el tiempo transcurrido (en ms) en una variable
	//Se usa solo en los escudos que funcionan en base a tiempo
	public void pasarTiempo(int t) {}
	
	//Devuelve si el objeto cumplio su tiempo de vida o no
	//Se usa solo en los escudos que funcionan en base a tiempo
	public boolean pasoTiempo() {
		return false;
	}
}
