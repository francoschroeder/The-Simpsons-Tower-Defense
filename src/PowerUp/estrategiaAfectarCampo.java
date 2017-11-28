package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;
import Juego.Personaje;

public class estrategiaAfectarCampo extends estrategiaVisitar{
	
	public estrategiaAfectarCampo() {
		
	}
	
	public void afectar(Aliado a) {
 		a.cambiarEstado(Personaje.protegido);
	}
 	
 	public void afectar(Enemigo e) {
 		
 	}
 	
 	public void afectar(Objeto o) {
 	}
 	
 	public void afectar(Market m) {
 		
 	}

}
