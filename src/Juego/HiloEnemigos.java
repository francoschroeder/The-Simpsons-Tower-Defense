package Juego;

import java.awt.Point;
import java.util.List;
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
		aSalir = enemigosPorSalir.pop();
		j.agregarPersonaje(aSalir, aSalir.getPosicion());
			
		Personaje blanco;
		List<Enemigo> enemigos = j.getEnemigos();
		
		while(seguir) {

			
			 if(!enemigos.isEmpty()) {
				 
				for (Enemigo actual : enemigos) {
				if (!actual.estaMuerto()) {
					
				if (j.hayRalentizador(actual)) 
					actual.ralentizar();
				else
					actual.desralentizar();
					
				//Muevo al personaje
				if (((actual.getImagen().getLocation().getX()+5)%75)<=5){ // llega al borde
					
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
			 }
			
			 try {
				Thread.sleep(200);
			} catch(Exception e) {}
			 
			cont++;
			
			if (cont==80 && !enemigosPorSalir.isEmpty()) {
				aSalir = enemigosPorSalir.pop();
				j.agregarPersonaje(aSalir, aSalir.getPosicion());
				cont=0;
			}
		}
	}
}

