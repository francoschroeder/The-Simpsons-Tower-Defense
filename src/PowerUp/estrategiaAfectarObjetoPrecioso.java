package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class estrategiaAfectarObjetoPrecioso extends estrategiaVisitar{

		public estrategiaAfectarObjetoPrecioso() {
	 		
	 	}
	 	public void afectar(Aliado a) {
	 		
	 	}
	 	
	 	public void afectar(Enemigo e) {
			
	 	}
	 	
	 	public void afectar(Objeto o) {
	 		
	 	}
	 	public void afectar(Market m) {
	 		m.sumarMonedas(100);
	 	}
	 }

