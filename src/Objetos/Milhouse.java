package Objetos;
import javax.swing.ImageIcon;

import Juego.*;

public class Milhouse extends Objeto {
	private int tiempoTranscurrido;	//Almacena el tiempo transcurrido desde que 
									//aparece el objeto (en ms)
	private int tiempoDeVida;		//Representa el tiempo maximo que puede quedar 
									//vivo (en ms)
	
	public Milhouse() {
		vidaMax=1;
		tiempoTranscurrido = 0;
		tiempoDeVida = 10000;
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/bart/bartNeutral.gif")));
		
		setImagen(Personaje.neutral_key);
	}
	
	public void serAtacado(Proyectil p) {}
	
	public void pasarTiempo(int t) {
		tiempoTranscurrido += t;
	}
	
	public boolean estaMuerto() {
		return tiempoTranscurrido>=tiempoDeVida;
	}
}
