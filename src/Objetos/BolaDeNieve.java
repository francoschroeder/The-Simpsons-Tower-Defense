package Objetos;
import Juego.*;

public class BolaDeNieve extends Objeto  {
	
	public BolaDeNieve() {
		super.vidaMax=20;
		super.tiempo=0;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
