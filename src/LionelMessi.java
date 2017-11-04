import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import GUI.GUIPrincipal;
import GUI.PanelMapa;
import GUI.Botones.Market;
import Juego.Enemigo;
import Juego.HiloAtaque;
import Juego.HiloDisparo;
import Juego.HiloEnemigos;
import Juego.Juego;
import Personajes.Barney;
import Personajes.MrBurns;
import Personajes.Nelson;
import Personajes.PerrosBurns;
import Personajes.Skinner;
import Personajes.Smithers;

public class LionelMessi {
	
	
		
	
	
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
	private static void crearEnemigosPorSalir(Stack<Enemigo> enemigosPorSalir) {
		
		LinkedList<Enemigo> enemigos = new LinkedList<Enemigo>();
		Random r = new Random();
		int cantPorSalir = r.nextInt(6) +15;
		
		Enemigo s1 = new Skinner();
		Enemigo s2 = new PerrosBurns();
		Enemigo s3 = new MrBurns();
		Enemigo s4 = new Smithers();
		Enemigo s5 = new Barney();
		Enemigo s6 = new Nelson();
		
		enemigos.add(s1);
		enemigos.add(s2);
		enemigos.add(s3);
		enemigos.add(s4);
		enemigos.add(s5);
		enemigos.add(s6);
		
		for(int i=0; i< cantPorSalir; i++) {
			Enemigo e = enemigos.get(r.nextInt(enemigos.size())).clone();
			Point pos = new Point(r.nextInt(6),0);
			e.setPosicion(pos);
			enemigosPorSalir.push(e);
		}
		
	
	}
}
