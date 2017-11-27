package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class estrategiaDesafectarAlcance extends estrategiaVisitar{
	
    public estrategiaDesafectarAlcance() {
    	
    }
	
    public void afectar(Aliado a) {
 		a.setRango(a.getRangoOriginal());
 	}
 	
 	public void afectar(Enemigo e) {
		
 	}
 	
 	public void afectar(Objeto o) {
 		
 	}
 	public void afectar(Market m) {
 		
 	}
}
