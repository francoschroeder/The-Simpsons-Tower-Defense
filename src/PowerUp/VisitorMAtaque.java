package PowerUp;
 
 import GUI.Botones.Market;
import Juego.Aliado;
 import Juego.Enemigo;
 import Juego.Objeto;
 
 public class VisitorMAtaque extends VisitorPowerUp {
	private int tiempoTranscurrido;
	private int tiempoDeVida;
	
 	public VisitorMAtaque() {
 		estrategia = new estrategiaAfectarAtaque();
 		 tiempoTranscurrido= 0;
 		tiempoDeVida = 10000;
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
 		
 		estrategia = new estrategiaDesafectarAtaque();
 	}
 	
 	public void pasarTiempo(int t) {
		tiempoTranscurrido+=t;
	}
	
	public boolean pasoTiempo() {
		return tiempoTranscurrido>=tiempoDeVida;
	}
 }
