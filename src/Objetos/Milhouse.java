package Objetos;
import Juego.*;

public class Milhouse extends Objeto {
	private int tiempoTranscurrido;	//Almacena el tiempo transcurrido desde que 
									//aparece el objeto (en ms)
	private int tiempoDeVida;		//Representa el tiempo maximo que puede quedar 
									//vivo (en ms)
	
	public Milhouse() {
		vidaMax=0;
		tiempoTranscurrido = 0;
		tiempoDeVida = 10000;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
	
	public void pasarTiempo(int t) {
		tiempoTranscurrido += t;
	}
	
	public boolean pasoTiempo() {
		return tiempoTranscurrido>=tiempoDeVida;
	}
}
