package Juego;

import GUI.GUIPrincipal;

public class Tiempo extends Thread {
	private Personaje personaje;
	private GUIPrincipal gui;
	
	public Tiempo(Personaje p, GUIPrincipal gui) {
		personaje=p;
		this.gui=gui;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		
			personaje.getImagen().setBounds((int) personaje.getImagen().getLocation().getX()+1,(int) personaje.getImagen().getLocation().getY(), 75, 75);
			
		}
	}
}
