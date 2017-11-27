package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class estrategiaAfectarAlcance extends estrategiaVisitar{
	
    public estrategiaAfectarAlcance() {
    	
    }
	
    public void afectar(Aliado a) {
 		a.setRango(a.getRango()+2);
 	}
 	
 	public void afectar(Enemigo e) {
		
 	}
 	
 	public void afectar(Objeto o) {
 		
 	}
 	public void afectar(Market m) {
 		
 	}
}
