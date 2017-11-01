package Objetos;
import Juego.*;

public class Flanders extends Objeto {
	public Flanders() {
		vidaMax=0;
		int tiempo=20;
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
	
	
}
