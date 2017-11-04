package PowerUp;

import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class VisitorMAlcance extends VisitorPowerUp {

	public void afectar(Aliado a) {
		a.setRango(a.getRango()+2);
	}
	
	public void afectar(Enemigo e) {
		
	}
	
	public void afectar(Objeto o) {
		
	}
}
