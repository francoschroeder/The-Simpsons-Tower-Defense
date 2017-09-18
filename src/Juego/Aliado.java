package Juego;

public abstract class Aliado extends Personaje {
	protected int costo; 
	
	public int getCosto() {
		return costo;
	}
	
	public void atacar(Enemigo p){
		p.reducirVida(this.ataque);
	}
	
	public void atacar(Aliado p){
	}
	public void atacar(Objecto p){
	}
	
	
}
