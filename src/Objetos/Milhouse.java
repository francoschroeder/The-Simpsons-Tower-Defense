package Objetos;
import Juego.*;

public class Milhouse extends Objeto {
	public Milhouse() {
		super.vidaMax=0;
		super.tiempo=10;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
