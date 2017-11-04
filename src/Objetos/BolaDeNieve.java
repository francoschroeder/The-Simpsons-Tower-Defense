package Objetos;
import Juego.*;

public class BolaDeNieve extends Objeto  {
	
	public BolaDeNieve() {
		vidaMax=20;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
