package PowerUp;
 
 import GUI.Botones.Market;
import Juego.Aliado;
 import Juego.Enemigo;
 import Juego.Objeto;
 
 public class VisitorMAtaque extends VisitorPowerUp {
 
 	public VisitorMAtaque() {
 		
 	}
 	public void afectar(Aliado a) {
 		a.setAtaque(a.getAtaque()+5);
 	}
 	
 	public void afectar(Enemigo e) {
		
 	}
 	
 	public void afectar(Objeto o) {
 		
 	}
 	public void afectar(Market m) {
 		
 	}
 }
