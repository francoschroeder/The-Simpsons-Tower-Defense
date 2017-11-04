package Objetos;
import Juego.*;

public class AyudanteDeSanta extends Objeto {
	
	public AyudanteDeSanta() {
		super.vidaMax=40;
		super.tiempo=0;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
