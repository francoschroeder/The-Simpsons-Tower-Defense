package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class estrategiaAfectarCuracion extends estrategiaVisitar{
	
	public void afectar(Aliado a) {
 		a.setVidaActual(a.getVidaMax());
 		a.actualizarVida();
 	}
 	
 	public void afectar(Enemigo e) {
		
 	}
 	
	public void afectar(Objeto o) {
 		o.setVidaActual(o.getVidaMax());
 		o.actualizarVida();
 	}
	
	public void afectar(Market m) {
 		
 	}

}
