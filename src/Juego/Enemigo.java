package Juego;

import javax.swing.ImageIcon;
import java.util.Random;

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
	
	public int serEliminado(){
		Random r = new Random();
		return r.nextInt((getMaxMonedas() - getMinMonedas()) + 1) + getMinMonedas();
	} 
	
	public Disparo generarDisparo(Personaje p) {
		return new DisparoEnemigo(new ProyectilEnemigo(ataque), this, p);
	}
	
	public void avanzar() {
	
		imagen.setLocation((int) (imagen.getLocation().getX()+1), (int) (imagen.getLocation().getY()));
		barraDeVida.setLocation((int) barraDeVida.getLocation().getX()+1, (int) barraDeVida.getLocation().getY());
	}
}
