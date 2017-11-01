package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;

import GUI.GUIPrincipal;
import GUI.PanelMapa;
import Personajes.Skinner;

public class HiloEnemigos extends Thread {
	private Juego j;
	private volatile boolean seguir;
	private Stack<Enemigo> enemigosPorSalir;
	private HiloDisparo disparos;
	public HiloEnemigos(Juego j, HiloDisparo disparos, Stack<Enemigo> s) {
		this.j=j;
		seguir=true;
		this.disparos = disparos;
		enemigosPorSalir = s;
	
	}
	
	public void detener() {
		seguir=false;
	}
	
	public void run() {
		int cont=0;
		Enemigo aSalir;
		LinkedList<Enemigo> enemigos = j.getEnemigos();
		
		aSalir = enemigosPorSalir.pop();
		j.agregarPersonaje(aSalir, aSalir.getPosicion());
		
		synchronized (enemigos) {
			enemigos.add(aSalir);
		}
			
		Personaje blanco;
		
		while(seguir) {
			
			for (Enemigo actual : enemigos) {
				if (!actual.estaMuerto()) {
				try {
					Thread.sleep((actual.getVelocidad()*80)/enemigos.size());
				} catch(Exception e) {}
				
				//Muevo al personaje
				if (((actual.getImagen().getLocation().getX()+30)%75)==0){ // llega al borde
					
					if (j.moverEnemigo(actual)){
					
							actual.avanzar();
					}
					else {
						System.out.println("punto enemigo: "+actual.getImagen().getLocation().getX());
					}
				}
				else{
					
					actual.avanzar();
				}
			}
			}
			
			cont++;
			
			if (cont==80 && !enemigosPorSalir.isEmpty()) {
				aSalir = enemigosPorSalir.pop();
				j.agregarPersonaje(aSalir, aSalir.getPosicion());
				aSalir.getImagen().setVisible(true);
				synchronized (enemigos) {
					enemigos.add(aSalir);
				}
				cont=0;
			}
		}
	}
}

