package Juego;

import javax.swing.ImageIcon;


public abstract class Enemigo extends Personaje {

	protected float velocidad;
	protected int minMonedas, maxMonedas;
	public static final String forward_key = "Forward";
		

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
		this.imActual.put(Personaje.still_key, new ImageIcon(this.getClass().getResource("/sprites/still.png")));
	
	}
	

}
