package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class VisitorCampoDeProteccion extends VisitorPowerUp {
	private int tiempoTranscurrido;
	private int tiempoDeVida;
	
 	public VisitorCampoDeProteccion() {
 		estrategia = new estrategiaAfectarCampo();
 		tiempoTranscurrido=0;
		tiempoDeVida=15000;
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
 		estrategia = new estrategiaDesafectarCampo();
 	}
 	
 	public void pasarTiempo(int t) {
		tiempoTranscurrido+=t;
	}
	
	public boolean pasoTiempo() {
		return tiempoTranscurrido>=tiempoDeVida;
	}
 	
 }
