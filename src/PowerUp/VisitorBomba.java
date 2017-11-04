package PowerUp; 
import Juego.Aliado;
 import Juego.Enemigo;
 import Juego.Objeto;
 
 public class VisitorBomba extends VisitorPowerUp {
 
 	public VisitorBomba() {
 		
 	}
 	
 	public void afectar(Aliado a) {
 		a.setVidaActual(a.getVidaActual()-15);
	}
 	
 	public void afectar(Enemigo e) {
 		e.setVidaActual(e.getVidaActual()-15);
 	}
 	
 	public void afectar(Objeto o) {
 	}
 	
 	}