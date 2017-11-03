import java.awt.Point;
import java.util.Stack;

import GUI.GUIPrincipal;
import GUI.PanelMapa;
import GUI.Botones.Market;
import Juego.Enemigo;
import Juego.HiloAtaque;
import Juego.HiloDisparo;
import Juego.HiloEnemigos;
import Juego.Juego;
import Personajes.Nelson;
import Personajes.Skinner;

public class LionelMessi {
	
	private static void crearEnemigosPorSalir(Stack<Enemigo> enemigosPorSalir) {
		Skinner s1 = new Skinner();
		s1.setPosicion(new Point(5, 0));
		enemigosPorSalir.push(s1);
		
		Skinner s2 = new Skinner();
		s2.setPosicion(new Point(3, 0));
		enemigosPorSalir.push(s2);
		
		Skinner s3 = new Skinner();
		s3.setPosicion(new Point(5, 0));
		enemigosPorSalir.push(s3);
		
		Skinner s4 = new Skinner();
		s4.setPosicion(new Point(2, 0));
		enemigosPorSalir.push(s4);
		
		Nelson s5 = new Nelson();
		s5.setPosicion(new Point(1, 0));
		enemigosPorSalir.push(s5);
		
	}
	
	public static void main(String[] args){
		Stack<Enemigo> enemigosPorSalir = new Stack<Enemigo>();
		GUIPrincipal gui = new GUIPrincipal();
		Juego j = new Juego(gui);
		crearEnemigosPorSalir(enemigosPorSalir);
		Market market = new Market(j);
		HiloDisparo disparo = new HiloDisparo(gui.getPanelMapa()); 
		HiloEnemigos h = new HiloEnemigos(j, disparo, enemigosPorSalir);
		HiloAtaque a = new HiloAtaque(j,disparo);
		
		gui.setJuego(j);
		gui.setMarket(market);
		gui.setVisible(true);
		h.start();
		disparo.start();
		a.start();
		
		
	
	}
}
