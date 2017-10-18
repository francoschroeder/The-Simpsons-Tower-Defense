package Juego;

import GUI.GUIPrincipal;

public class Tiempo extends Thread {
	private Personaje skinner;
	private GUIPrincipal gui;
	
	public Tiempo(Personaje p, GUIPrincipal gui) {
		skinner=p;
		this.gui=gui;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		
			skinner.getImagen().setBounds((int) skinner.getImagen().getLocation().getX()+1,(int) skinner.getImagen().getLocation().getY(), 75, 75);
			
		}
	}
}
