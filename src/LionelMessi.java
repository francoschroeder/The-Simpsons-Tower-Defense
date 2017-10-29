import GUI.GUIPrincipal;
import GUI.Botones.Market;
import Juego.HiloDisparo;
import Juego.HiloEnemigos;
import Juego.Juego;

public class LionelMessi {
	public static void main(String[] args){
		GUIPrincipal gui = new GUIPrincipal();
		Juego j = new Juego(gui);
		Market market = new Market(j);
		HiloDisparo disparo = new HiloDisparo(); 
		HiloEnemigos h = new HiloEnemigos(j, gui,disparo);
		
		gui.setJuego(j);
		gui.setMarket(market);
		gui.setVisible(true);
		h.start();
	}
}
