package PowerUp; 
import GUI.Botones.Market;
import Juego.Aliado;
 import Juego.Enemigo;
 import Juego.Objeto;
 
 public class VisitorBomba extends VisitorPowerUp {
 
 	public VisitorBomba() {
 		estrategia = new estrategiaAfectarBomba();
 	}
 	
 	public void afectar(Aliado a) {
 		estrategia.afectar(a);
	}
 	
 	public void afectar(Enemigo e) {
 		estrategia.afectar(e);
 	}
 	
 	public void afectar(Objeto o) {
 	}
 	
 	public void afectar(Market m) {
 		
 	}
 	
 	public void modoDesafectar() {
 		estrategia = new estrategiaDesafectarBomba();
 	}
 	
 	}