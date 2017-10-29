package Objetos;
import Juego.*;

public class AyudanteDeSanta extends Objeto implements Comprable {
	
	public AyudanteDeSanta() {
		super.vidaMax=40;
		super.tiempo=0;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
