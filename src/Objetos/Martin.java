package Objetos;
import javax.swing.ImageIcon;

import Juego.*;

public class Martin extends Objeto  {
	
	public Martin() {
		vidaMax=300;
		vidaActual = vidaMax;
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/martin/martinNeutral.gif")));
		
		setImagen(Personaje.neutral_key);
	
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
