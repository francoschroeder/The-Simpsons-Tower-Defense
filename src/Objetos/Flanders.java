package Objetos;
import javax.swing.ImageIcon;

import Juego.*;

public class Flanders extends Objeto {
	private int tiempoTranscurrido;	//Almacena el tiempo transcurrido desde que 
									//aparece el objeto (en ms)
	private int tiempoDeVida;  		//Representa el tiempo maximo que puede quedar 
									//vivo (en ms)
	
	public Flanders() {
		rango=0;
		tiempoTranscurrido = 0;
		tiempoDeVida = 20000;
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/flanders/flandersNeutral.gif")));
		
		setImagen(Personaje.neutral_key);
		
	}
	
	public void serAtacado(Proyectil p) {}
	
	public void pasarTiempo(int t) {
		tiempoTranscurrido+=t;
	}
	
	public boolean estaMuerto() {
		return tiempoTranscurrido>=tiempoDeVida;
	}
	
	public void actualizarVida() {
		barraDeVida.setBounds(getImagen().getX(), getImagen().getY()-4,((tiempoDeVida-tiempoTranscurrido)*75)/tiempoDeVida, 5);
	}
}
