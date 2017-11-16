package Juego;

public abstract class Comprable extends Personaje {
	protected int costo;

	public int getCosto(){
		return costo;
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
