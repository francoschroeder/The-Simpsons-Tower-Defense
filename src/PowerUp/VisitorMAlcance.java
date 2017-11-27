package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class VisitorMAlcance extends VisitorPowerUp {
	private int tiempoTranscurrido;
	private int tiempoDeVida;
	
	public VisitorMAlcance() {
		estrategia = new estrategiaAfectarAlcance();
		tiempoTranscurrido=0;
		tiempoDeVida=5000;
	}
	
	public void afectar(Aliado a) {
		estrategia.afectar(a);
	}
	
	public void afectar(Enemigo e) {
		
	}
	
	public void afectar(Objeto o) {
		
	}
	
	public void afectar(Market m) {
 		
 	}
	
	public void modoDesafectar() {
		estrategia = new estrategiaDesafectarAlcance();
	}
	
	public void pasarTiempo(int t) {
		tiempoTranscurrido+=t;
	}
	
	public boolean pasoTiempo() {
		return tiempoTranscurrido>=tiempoDeVida;
	}
}
