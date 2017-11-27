package PowerUp;
 
 import GUI.Botones.Market;
import Juego.Aliado;
 import Juego.Enemigo;
 import Juego.Objeto;
 
 public class VisitorMAtaque extends VisitorPowerUp {
 
 	public VisitorMAtaque() {
 		estrategia = new estrategiaAfectarAtaque();
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
 }
