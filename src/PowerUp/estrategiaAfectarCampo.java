package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class estrategiaAfectarCampo extends estrategiaVisitar{
	
	public estrategiaAfectarCampo() {
		
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
