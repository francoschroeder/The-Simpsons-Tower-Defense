package PowerUp;

import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class VisitorCuracion extends VisitorPowerUp {
	 
	 	public VisitorCuracion() {
	 		
	 	}
	 	
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
	 
	 }
