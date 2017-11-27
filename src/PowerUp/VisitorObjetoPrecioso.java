package PowerUp;

import GUI.Botones.Market;
import Juego.Aliado;
import Juego.Enemigo;
import Juego.Objeto;

public class VisitorObjetoPrecioso extends VisitorPowerUp {
 
 	public VisitorObjetoPrecioso() {
 		estrategia = new estrategiaAfectarObjetoPrecioso();
 	}
 	public void afectar(Aliado a) {
 		
 	}
 	
 	public void afectar(Enemigo e) {
		
 	}
 	
 	public void afectar(Objeto o) {
 		
 	}
 	public void afectar(Market m) {
 		estrategia.afectar(m);
 	}
 	
 	public void modoDesafectar() {
 		estrategia = new  estrategiaDesafectarObjetosPrecisos();
 	}
 }