package Juego;

import PowerUp.VisitorPowerUp;

import java.util.Random;

public abstract class Enemigo extends Personaje {

	protected int velocidadActual;
	protected int velocidadMaxima;
	protected int minMonedas, maxMonedas, puntos;
		
	public Enemigo() {
		super();
	}
	
	public int getVelocidad(){
		return velocidadActual;
	}
	
	public void setVelocidad(int v){
		velocidadActual = v;
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
	
	public void afectar(VisitorPowerUp p) {
		p.afectar(this);
	}
	
	public int serEliminado(){
		Random r = new Random();
		return r.nextInt((getMaxMonedas() - getMinMonedas()) + 1) + getMinMonedas();
	} 
	
	public Disparo generarDisparo(Personaje p) {
		return new DisparoEnemigo(miProyectil, this, p);
	}
	
	public void avanzar() {
	
		imagen.setLocation((int) (imagen.getLocation().getX()+velocidadActual), (int) (imagen.getLocation().getY()));
		actualizarVida();
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public abstract Enemigo clone();
}
