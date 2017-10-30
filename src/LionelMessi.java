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
import Personajes.Skinner;

public class LionelMessi {
	
	private static void crearEnemigosPorSalir(PanelMapa panel, Stack<Enemigo> enemigosPorSalir) {
		Skinner s1 = new Skinner();
		s1.setPosicion(new Point(0, 0));
		s1.getImagen().setBounds(0*75+1, 0*75, 75, 75);
		panel.add(s1.getImagen());
		s1.getImagen().setVisible(false);
		enemigosPorSalir.push(s1);
		
		Skinner s2 = new Skinner();
		s2.setPosicion(new Point(0, 3));
		s2.getImagen().setBounds(0*75+1, 3*75, 75, 75);
		panel.add(s2.getImagen());
		s2.getImagen().setVisible(false);
		enemigosPorSalir.push(s2);
		
		Skinner s3 = new Skinner();
		s3.setPosicion(new Point(0, 5));
		s3.getImagen().setBounds(0*75+1, 5*75, 75, 75);
		panel.add(s3.getImagen());
		s3.getImagen().setVisible(false);
		enemigosPorSalir.push(s3);
		
		Skinner s4 = new Skinner();
		s4.setPosicion(new Point(0, 2));
		s4.getImagen().setBounds(0*75+1, 2*75, 75, 75);
		panel.add(s4.getImagen());
		s4.getImagen().setVisible(false);
		enemigosPorSalir.push(s4);
		
		Skinner s5 = new Skinner();
		s5.setPosicion(new Point(0, 5));
		s5.getImagen().setBounds(0*75+1, 5*75, 75, 75);
		panel.add(s5.getImagen());
		s5.getImagen().setVisible(false);
		enemigosPorSalir.push(s5);
		
	}
	
	public static void main(String[] args){
		Stack<Enemigo> enemigosPorSalir = new Stack<Enemigo>();
		GUIPrincipal gui = new GUIPrincipal();
		crearEnemigosPorSalir(gui.getPanelMapa(), enemigosPorSalir);
		Juego j = new Juego(gui);
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
