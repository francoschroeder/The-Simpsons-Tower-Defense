package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class VisitorCuracion extends VisitorPowerUp {
	 
	 	public VisitorCuracion() {
	 		estrategia = new estrategiaAfectarCuracion(); 
	 	}
	 	
	 	public void afectar(Aliado a) {
	 		estrategia.afectar(a);
	 	}
	 	
	 	public void afectar(Enemigo e) {
			
	 	}
	 	
		public void afectar(Objeto o) {
	 		estrategia.afectar(o);
	 	}
		
		public void afectar(Market m) {
	 		
	 	}
		
		public void modoDesafectar() {
			estrategia = new estrategiaDesafectarCuracion();
		}
	 
	 }
