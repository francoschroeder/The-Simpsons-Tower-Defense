package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class estrategiaAfectarBomba extends estrategiaVisitar{
	
	public estrategiaAfectarBomba() {
		
	}
	
	public void afectar(Aliado a) {
 		a.setVidaActual(a.getVidaActual()-15);
	}
 	
 	public void afectar(Enemigo e) {
 		e.setVidaActual(e.getVidaActual()-15);
 	}
 	
 	public void afectar(Objeto o) {
 	}
 	
 	public void afectar(Market m) {
 		
 	}

}
