
package Juego;

import java.util.LinkedList;

import GUI.PanelMapa;

public class HiloDisparo extends Thread {
	
	private volatile boolean seguir, pausa;
	private LinkedList<Disparo> disparos;
	private LinkedList<Disparo> morirDisparo;
	private PanelMapa panel;
	
	public HiloDisparo(PanelMapa gui){
		seguir = true;
		pausa = false;
		morirDisparo = new LinkedList<Disparo>();
		disparos = new LinkedList<Disparo>();
		this.panel = gui;
	}

	public void pausar() {
		if (pausa)
			pausa = false;
		else
			pausa = true;
	}
	
	public void detener() {
		seguir=false;
		pausa=true;
	}
	
	public void run(){
		
		while (seguir){
			while (!pausa) {
				try {
				Thread.sleep(20);
			} catch(Exception e) {} 
			synchronized(disparos){
				for(Disparo actual : disparos){
					actual.move();
					if(actual.colisione()){
								actual.Atacar();
								panel.validate();
								panel.repaint();
								morirDisparo.add(actual);
						}
					
				 }
				
			for(Disparo actual : morirDisparo){
				disparos.remove(actual);
				panel.remove(actual.getImagen());
				panel.validate();
				panel.repaint();
						}
				}
			
				
			}
			
			}
		
		}
	
	public void agregarDisparo(Disparo disparo){
		synchronized(disparos){
			disparos.add(disparo);
			disparo.getImagen().setBounds((int) disparo.getInicio().getImagen().getLocation().getX() +3,(int)disparo.getInicio().getImagen().getLocation().getY(), 75, 75);
			panel.add(disparo.getImagen());
			disparo.getImagen().setVisible(true);
		}
	}

	
}
	

