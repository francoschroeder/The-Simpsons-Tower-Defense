package Juego;

import javax.swing.ImageIcon;

import juego.Entidad;

public abstract class Enemigo extends Personaje {
	private float velocidad;
	private int minMonedas, maxMonedas;
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
		this.image.put(Entidad.forward_key, new ImageIcon(this.getClass().getResource("/sprites/step1.png")));
		this.image.put(Entidad.backward_key, new ImageIcon(this.getClass().getResource("/sprites/back1.png")));
		this.image.put(Entidad.jump_key, new ImageIcon(this.getClass().getResource("/sprites/jump.png")));
		
	}
	

}
