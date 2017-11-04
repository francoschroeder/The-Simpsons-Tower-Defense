package Objetos;
import Juego.*;

public class Flanders extends Objeto {
	private int tiempoTranscurrido;	//Almacena el tiempo transcurrido desde que 
									//aparece el objeto (en ms)
	private int tiempoDeVida;  		//Representa el tiempo maximo que puede quedar 
									//vivo (en ms)
	
	public Flanders() {
		vidaMax=0;
		tiempoTranscurrido = 0;
		tiempoDeVida = 20000;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
	
	public void pasarTiempo(int t) {
		tiempoTranscurrido+=t;
	}
	
	public boolean pasoTiempo() {
		return tiempoTranscurrido>=tiempoDeVida;
	}
}
