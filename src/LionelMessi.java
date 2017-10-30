import GUI.GUIPrincipal;
import GUI.Botones.Market;
import Juego.HiloAtaque;
import Juego.HiloDisparo;
import Juego.HiloEnemigos;
import Juego.Juego;

public class LionelMessi {
	
	
	public static void main(String[] args){
		GUIPrincipal gui = new GUIPrincipal();
		Juego j = new Juego(gui);
		Market market = new Market(j);
		HiloDisparo disparo = new HiloDisparo(gui.getPanelMapa()); 
		HiloEnemigos h = new HiloEnemigos(j, gui,disparo);
		HiloAtaque a = new HiloAtaque(j,disparo);
		gui.setJuego(j);
		gui.setMarket(market);
		gui.setVisible(true);
		h.start();
		disparo.start();
		a.start();
	}
}
