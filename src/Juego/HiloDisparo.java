package Juego;

import java.util.LinkedList;
import java.util.Stack;

import GUI.PanelMapa;

public class HiloDisparo extends Thread {
	
	private boolean seguir;
	private LinkedList<Disparo> disparos;
	private LinkedList<Disparo> morirDisparo;
	
	public HiloDisparo(){
		seguir = true;
		morirDisparo = new LinkedList<Disparo>();
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
					else{
						morirDisparo.add(actual);
						}
				}
			}
			
			for(Disparo actual : morirDisparo){
				disparos.remove(actual);
						}
			}
		
		}
	
	public void agregarDisparo(Disparo disparo){
		
		
	}
	
	
	
	
	
	
}
	
