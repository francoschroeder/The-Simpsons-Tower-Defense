package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class estrategiaDesafectarAtaque extends estrategiaVisitar{
	
public estrategiaDesafectarAtaque() {}
	
	public void afectar(Aliado a) {
 		a.setAtaque(a.getAtaqueOriginal());
 	}
 	
 	public void afectar(Enemigo e) {
		
 	}
 	
 	public void afectar(Objeto o) {
 		
 	}
 	public void afectar(Market m) {
 		

	}

}
