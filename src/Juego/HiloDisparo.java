package Juego;

import java.util.LinkedList;
import java.util.Stack;

import GUI.PanelMapa;

public class HiloDisparo extends Thread {
	
	private boolean seguir;
	private LinkedList<Disparo> disparos;
	
	public HiloDisparo(){
		seguir = true;
		disparos = new LinkedList<Disparo>();
	}

	public void run(){
		
		while (seguir){
			 
			if(!disparos.isEmpty()){
				for(Disparo actual : disparos){
					if(actual.getImagen().getLocation() != actual.getDestino().getImagen().getLocation()){
						actual.getImagen().setBounds((int) (actual.getImagen().getLocation().getX()+1),
										(int) (actual.getImagen().getLocation().getY()), 75, 75);
						}
				
					
				}
				
			}
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	
	
}
	
