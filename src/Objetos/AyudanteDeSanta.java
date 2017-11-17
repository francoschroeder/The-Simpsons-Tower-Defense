package Objetos;
import javax.swing.ImageIcon;

import Juego.*;

public class AyudanteDeSanta extends Objeto {
	
	public AyudanteDeSanta() {
		vidaMax=300;
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/ayudanteSanta/attack.gif")));
		imActual.put(Personaje.shoot_key, new ImageIcon(this.getClass().getResource("/sprites/ayudanteSanta/attack.gif")));
		setImagen(Personaje.neutral_key);
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}