package Objetos;
import javax.swing.ImageIcon;

import Juego.*;

public class Selma extends Objeto {
	
	public Selma() {
		vidaMax=150;
		vidaActual = vidaMax;
		costo = 15;
		
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/selma/selmaNeutral.gif")));
		
		setImagen(Personaje.neutral_key);
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}