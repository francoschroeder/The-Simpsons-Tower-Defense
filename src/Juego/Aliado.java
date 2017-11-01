package Juego;

public abstract class Aliado extends Personaje {
	protected int costo; 
	
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
		return new DisparoAliado(new ProyectilAliado(ataque), this, p);
	}
	
	public void avanzar(){}
}
