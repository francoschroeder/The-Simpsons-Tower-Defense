package Objetos;
import Juego.*;

public class AyudanteDeSanta extends Objeto {
	
	public AyudanteDeSanta() {
		vidaMax=300;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}