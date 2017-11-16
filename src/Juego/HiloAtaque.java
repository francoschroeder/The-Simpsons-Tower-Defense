package Juego;

import java.util.LinkedList;
import java.util.List;

public class HiloAtaque extends Thread {
	private Juego juego;
	private volatile boolean seguir;
	private HiloDisparo disparos;
	
	public HiloAtaque(Juego j, HiloDisparo h) {
		juego = j;
		disparos = h;
		seguir=true;
	}
	
	public void detener() {
		seguir=false;
	}
	
	public void run() {
		
		LinkedList<Comprable> aEliminar = new LinkedList<Comprable>();
		LinkedList<Enemigo> aEliminar2 = new LinkedList<Enemigo>();
		
		Personaje aAtacar;
		
		List<Comprable> listaAliados = juego.getAliados();
		List<Enemigo> listaEnemigos =  juego.getEnemigos();
		
		while (seguir) {
			
			synchronized (listaAliados) {
				for (Comprable a:listaAliados) {
					a.pasarTiempo(1000);
					
					//Pide un blanco dentro del rango de ataque
					
					aAtacar = juego.getBlanco(a);
					
					//Ataca al blanco
					
					if (aAtacar!=null) {
						System.out.println("Dispara Aliado");
						a.setImagen(Personaje.shoot_key); // Cambia imagen a disparo
						disparos.agregarDisparo(a.generarDisparo(aAtacar));		
					} else {
						a.setImagen(Personaje.neutral_key);
					}
					
					if (a.estaMuerto()) {
						aEliminar.add(a);
						} else {
						
						}
				
					}
				}
			
				

				//Se eliminan los personajes muertos
			
				for (Comprable p:aEliminar) {
				juego.eliminar(p);
				}
			
			aEliminar = new LinkedList<Comprable>();

			// recorrer los enemigos
			synchronized (listaEnemigos) {
				for (Enemigo e:listaEnemigos) {
				
				//Pide un blanco dentro del rango de ataque
				
				aAtacar = juego.getBlanco(e);
				
				//Ataca al blanco
				
				if (aAtacar!=null) {
					System.out.println("Dispara Enemigo");
					e.setImagen(Personaje.shoot_key); // Cambia imagen a disparo
					disparos.agregarDisparo(e.generarDisparo(aAtacar));
				}  else {
					e.setImagen(Personaje.neutral_key);
				}
						
						
				if (e.estaMuerto()) {
					aEliminar2.add(e);
					} else {
					
					}
				}
			
			}
			
			//Se eliminan los personajes muertos
				for (Enemigo p:aEliminar2) {
					juego.eliminar(p);
					}
				aEliminar2 = new LinkedList<Enemigo>();
				
			try {
					Thread.sleep(1000);	}
					catch (InterruptedException j) {}
			}// del while
		}// del run
	}// del thread