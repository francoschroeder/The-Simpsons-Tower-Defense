package Juego;

import javax.swing.ImageIcon;


public abstract class Enemigo extends Personaje {

	protected int velocidad;
	protected int minMonedas, maxMonedas;
	public static final String forward_key = "Forward";
		

	public int getVelocidad(){
		return velocidad;
	}
	
	public void setVelocidad(int v){
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
	
	public void serAtacado(Proyectil p) {
		p.atacarEnemigo(this);
	}
}
