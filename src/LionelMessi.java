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
	
	private static void crearEnemigosPorSalir(PanelMapa panel, Stack<Enemigo> enemigosPorSalir, Juego j) {
		Skinner s1 = new Skinner();
		s1.setPosicion(new Point(0, 0));
		j.agregarPersonaje(s1, s1.getPosicion());
		s1.getImagen().setBounds(0*75+1, 0*75, 75, 75);
		panel.add(s1.getImagen());
		s1.actualizarVida();
		panel.add(s1.getBarraDeVida());
		s1.getBarraDeVida().setVisible(true);
		s1.getImagen().setVisible(false);
		enemigosPorSalir.push(s1);
		
		Skinner s2 = new Skinner();
		s2.setPosicion(new Point(0, 3));
		j.agregarPersonaje(s2, s2.getPosicion());
		s2.getImagen().setBounds(0*75+1, 3*75, 75, 75);
		panel.add(s2.getImagen());
		s2.actualizarVida();
		panel.add(s2.getBarraDeVida());
		s2.getBarraDeVida().setVisible(true);
		s2.getImagen().setVisible(false);
		enemigosPorSalir.push(s2);
		
		Skinner s3 = new Skinner();
		s3.setPosicion(new Point(0, 5));
		j.agregarPersonaje(s3, s3.getPosicion());
		s3.getImagen().setBounds(0*75+1, 5*75, 75, 75);
		panel.add(s3.getImagen());
		s3.actualizarVida();
		panel.add(s3.getBarraDeVida());
		s3.getBarraDeVida().setVisible(true);
		s3.getImagen().setVisible(false);
		enemigosPorSalir.push(s3);
		
		Skinner s4 = new Skinner();
		s4.setPosicion(new Point(0, 2));
		j.agregarPersonaje(s4, s4.getPosicion());
		s4.getImagen().setBounds(0*75+1, 2*75, 75, 75);
		panel.add(s4.getImagen());
		s4.actualizarVida();
		panel.add(s4.getBarraDeVida());
		s4.getBarraDeVida().setVisible(true);
		s4.getImagen().setVisible(false);
		enemigosPorSalir.push(s4);
		
		Skinner s5 = new Skinner();
		s5.setPosicion(new Point(0, 5));
		j.agregarPersonaje(s5, s5.getPosicion());
		s5.getImagen().setBounds(0*75+1, 5*75, 75, 75);
		panel.add(s5.getImagen());
		s5.actualizarVida();
		panel.add(s5.getBarraDeVida());
		s5.getBarraDeVida().setVisible(true);
		s5.getImagen().setVisible(false);
		enemigosPorSalir.push(s5);
		
	}
	
	public static void main(String[] args){
		Stack<Enemigo> enemigosPorSalir = new Stack<Enemigo>();
		GUIPrincipal gui = new GUIPrincipal();
		Juego j = new Juego(gui);
		crearEnemigosPorSalir(gui.getPanelMapa(), enemigosPorSalir, j);
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
