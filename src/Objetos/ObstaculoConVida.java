package Objetos;

import java.awt.Point;
import java.util.Random;

import javax.swing.ImageIcon;

import Juego.Objeto;
import Juego.Personaje;
import Juego.Proyectil;

public class ObstaculoConVida extends Objeto {
	
	public ObstaculoConVida() {
		rango=0;
		vidaMax=300;
		vidaActual=vidaMax;
		Random rand = new Random();
		
		Point punto = new Point(rand.nextInt(4)+1, rand.nextInt(9));
		setPosicion(punto);
		imActual.put(Personaje.neutral_key, new ImageIcon(this.getClass().getResource("/sprites/obstaculos/obstaculo1.png")));
		setImagen(Personaje.neutral_key);
	}
	
	public void serAtacado(Proyectil p) {
		p.atacarObjeto(this);
	}
}
