package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class estrategiaDesafectarCampo extends estrategiaVisitar{
	
	public estrategiaDesafectarCampo() {
		
	}
	
	public void afectar(Aliado a) {
 		a.cambiarEstado();
	}
 	
 	public void afectar(Enemigo e) {
 		
 	}
 	
 	public void afectar(Objeto o) {
 	}
 	
 	public void afectar(Market m) {
 		
 	}

}
