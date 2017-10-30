package Objetos;
import Juego.*;

public class Flanders extends Objeto implements Comprable {
	public Flanders() {
		super.vidaMax=0;
		super.tiempo=20;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
