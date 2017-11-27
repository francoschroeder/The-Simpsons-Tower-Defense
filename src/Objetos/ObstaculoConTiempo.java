package Objetos;

import java.awt.Color;
import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

import Juego.Objeto;
import Juego.Personaje;
import Juego.Proyectil;

public class ObstaculoConTiempo extends Objeto {
	private int tiempoTranscurrido;	//Almacena el tiempo transcurrido desde que 
									//aparece el objeto (en ms)
	private int tiempoDeVida;  		//Representa el tiempo maximo que puede quedar 
									//vivo (en ms)
	public ObstaculoConTiempo() {
		rango=0;
		tiempoDeVida=75000;
		tiempoTranscurrido=0;
		
		Random rand = new Random();
		
		Point punto = new Point(rand.nextInt(4)+1, rand.nextInt(9));
		setPosicion(punto);
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/obstaculos/obstaculo2.png")));
		setImagen(Personaje.neutral_key);
	}
	
	public void pasarTiempo(int t) {
		tiempoTranscurrido+=t;
	}
	
	public boolean estaMuerto() {
		return tiempoTranscurrido>=tiempoDeVida;
	}
	
	public void actualizarVida() {
		if (tiempoTranscurrido==tiempoDeVida)
			barraDeVida.setBackground(Color.GREEN);
		else if (((tiempoDeVida-tiempoTranscurrido)*75)/tiempoDeVida<=40)
			barraDeVida.setBackground(Color.RED);
		else
			barraDeVida.setBackground(Color.YELLOW);
		
		barraDeVida.setBounds(getImagen().getX(), getImagen().getY()-4,((tiempoDeVida-tiempoTranscurrido)*75)/tiempoDeVida, 5);
	}
	
	public void serAtacado(Proyectil p) {} 
}
