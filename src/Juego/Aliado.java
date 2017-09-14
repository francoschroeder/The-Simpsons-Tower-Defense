package Juego;

public abstract class Aliado extends Personaje {
	private int costo; 
	
	public int getCosto() {
		return costo;
	}
	public void setCosto(int c) {
		costo = c;
	}
}
