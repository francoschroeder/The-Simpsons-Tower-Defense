package Juego;

public abstract class Aliado extends Personaje {
	protected int costo; 
	
	public int getCosto() {
		return costo;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarAliado(this);
	}
}
