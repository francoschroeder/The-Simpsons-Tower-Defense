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
	private PanelMapa panel;
	
	public HiloDisparo(PanelMapa gui){
		seguir = true;
		morirDisparo = new LinkedList<Disparo>();
		disparos = new LinkedList<Disparo>();
		this.panel = gui;
	}


	
	
	public void run(){
		
		while (seguir){
			try {
				Thread.sleep(20);
			} catch(Exception e) {} 
			if(!disparos.isEmpty()){
				System.out.println("entro a la lista de balas");
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
								actual.Atacar();
								morirDisparo.add(actual);
						}
					}
				}
			
			for(Disparo actual : morirDisparo){
				disparos.remove(actual);
				panel.remove(actual.getImagen());
						}
				}
			
				
			}
		
		}
	
	public void agregarDisparo(Disparo disparo){
		
		synchronized(disparos){
			System.out.println("agregando bala");
			disparos.add(disparo);
			disparo.getImagen().setBounds((int)disparo.getInicio().getImagen().getLocation().getX()+2,(int)disparo.getInicio().getImagen().getLocation().getY(), 75, 75);
			panel.add(disparo.getImagen());
			disparo.getImagen().setVisible(true);
		}
	}
	
}
	
