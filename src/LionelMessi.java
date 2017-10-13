import GUI.GUIPrincipal;
import GUI.Botones.Market;


import Juego.Juego;

public class LionelMessi {
	
	
	
	
	
	public static void main(String[] args){
		GUIPrincipal gui = new GUIPrincipal();
		Juego j = new Juego(gui);
		Market market = new Market(j);
		gui.setJuego(j);
		gui.setMarket(market);
		gui.setVisible(true);
	}
}
