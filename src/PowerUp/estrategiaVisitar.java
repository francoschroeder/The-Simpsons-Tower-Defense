package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public abstract class estrategiaVisitar {

	public abstract void afectar(Aliado a);
	
	public abstract void afectar(Enemigo e);
	
	public abstract void afectar(Objeto o);
	
	public abstract void afectar(Market m);


}
