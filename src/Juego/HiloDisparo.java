package Juego;

import java.util.LinkedList;
import java.util.Stack;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

import GUI.GUIPrincipal;
import GUI.PanelMapa;

public class HiloDisparo extends Thread {
	
	private boolean seguir;
	private LinkedList<Disparo> disparos;
	private LinkedList<Disparo> morirDisparo;
	private GUIPrincipal gui;
	
	public HiloDisparo(GUIPrincipal gui){
		seguir = true;
		morirDisparo = new LinkedList<Disparo>();
		disparos = new LinkedList<Disparo>();
		this.gui = gui;
	}


	
	
	public void run(){
		
		while (seguir){
			try {
				System.out.println("aentro al sleep");
				 Thread.sleep(5);
				} catch(Exception e) {} 
			if(!disparos.isEmpty()){
				
				for(Disparo actual : disparos){
					if (actual.getImagen().getLocation() != actual.getDestino().getImagen().getLocation()) {
							//EN el caso que la bala deba ir hacia a la derecha
							if(actual.getDestino().getImagen().getLocation().getX() > actual.getImagen().getLocation().getX())
							{
								System.out.println("moviendo a la derecha");
								actual.getImagen().setBounds((int) (actual.getImagen().getLocation().getX()+1),(int) (actual.getImagen().getLocation().getY()), 75, 75);
								
							}
							// en caso de que la bala deba ir a la izquierda.
							if(actual.getDestino().getImagen().getLocation().getX() < actual.getImagen().getLocation().getX()){
								actual.getImagen().setBounds((int) (actual.getImagen().getLocation().getX()-1),
										(int) (actual.getImagen().getLocation().getY()), 75, 75);
							}
							else{
								morirDisparo.add(actual);
						}
					}
				}
			
			for(Disparo actual : morirDisparo){
				disparos.remove(actual);
				gui.getPanelMapa().remove(actual.getImagen());
						}
				}
			}
		
		}
	
	public void agregarDisparo(Disparo disparo){
		
		synchronized(disparos){
			System.out.println("agregando bala");
			disparos.add(disparo);
		}
	}
	
	
	
	
	
	
}
	
