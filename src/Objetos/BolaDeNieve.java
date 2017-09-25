package Objetos;
import Juego.*;

public class BolaDeNieve extends Objecto implements Comprable {
	
	public BolaDeNieve() {
		super.vidaMax=20;
		super.tiempo=0;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
