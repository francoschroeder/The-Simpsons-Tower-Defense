package Juego;

public abstract class Enemigo extends Personaje {
	private float velocidad;
	private int minMonedas, maxMonedas;
	

	public float getVelocidad(){
		return velocidad;
	}
	
	public void setVelocidad(float v){
		velocidad = v;
	}
	
	public int getMinMonedas(){
		return minMonedas;
	}
	
	public void setMinMonedas(int m){
		minMonedas = m;
	}
	
	public int getMaxMonedas(){
		return maxMonedas;
	}
	
	public void setMaxMonedas(int m){
		maxMonedas = m;
	}
	
	public void atacar(Enemigo p) {
		p.reducirVida(getAtaque());		
	}
	

}
