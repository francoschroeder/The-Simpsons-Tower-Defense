package PowerUp;

import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public abstract class VisitorPowerUp {
		
		public abstract void afectar(Aliado a);
		
		public abstract void afectar(Enemigo e);
		
		public abstract void afectar(Objeto o);
}
