package Juego;

public abstract class Aliado extends Personaje {
	private int costo; 
	
	public int getCosto() {
		return costo;
	}
	public void setCosto(int c) {
		costo = c;
	}
	
	public void atacar(Enemigo p){
		p.setVidaMax(p.getAtaque());
	}
	
	public void atacar(Aliado p){
	}
	public void atacar(Objecto p){
	}
	
	
}
