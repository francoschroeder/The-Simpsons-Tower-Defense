package Juego;

import GUI.FramePrincipal;

public class Tiempo extends Thread {
	private Personaje skinner;
	private FramePrincipal gui;
	
	public Tiempo(Personaje p, FramePrincipal gui) {
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
