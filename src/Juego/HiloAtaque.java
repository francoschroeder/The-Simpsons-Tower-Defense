package Juego;

import java.util.LinkedList;

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
		
		
		
		LinkedList<Personaje> aEliminar = new LinkedList<Personaje>();
		
		Personaje aAtacar;
		
		while (seguir) {

			LinkedList<Comprable> listaAliados = (LinkedList<Comprable>) juego.getAliados().clone();
				for (Comprable a:listaAliados) {
					
					//Pide un blanco dentro del rango de ataque
					
					aAtacar = juego.getBlanco(a);
					
					//Ataca al blanco
					
					if (aAtacar!=null) {
						try {
							Thread.sleep(300/listaAliados.size());
							System.out.println("Dispara Aliado");
							a.setImagen(Personaje.shoot_key); // Cambia imagen a disparo;
							disparos.agregarDisparo(a.generarDisparo(aAtacar));
							}  
							catch(InterruptedException e) {}
					
					if (a.estaMuerto()) {
						aEliminar.add(a);
						} else {
						a.setImagen(Personaje.neutral_key);
						}
				
					}
				}

				//Se eliminan los personajes muertos
			
				for (Personaje p:aEliminar) {
				juego.eliminar(p);
				
				}
			
			aEliminar = new LinkedList<Personaje>();

			
			LinkedList<Enemigo> listaEnemigos = (LinkedList<Enemigo>) juego.getEnemigos().clone();
			
			for (Enemigo e:listaEnemigos) {

				//Pide un blanco dentro del rango de ataque
				
				aAtacar = juego.getBlanco(e);
				
				//Ataca al blanco
				
				if (aAtacar!=null) {
					try {
						Thread.sleep(300/listaEnemigos.size());
						System.out.println("Dispara Enemigo");
						e.setImagen(Personaje.shoot_key); // Cambia imagen a disparo;
						disparos.agregarDisparo(e.generarDisparo(aAtacar));
						}  
						catch(InterruptedException j) {}
				
				if (e.estaMuerto()) {
					aEliminar.add(e);
					} else {
					e.setImagen(Personaje.neutral_key);
					}
				}
			
			}


		
		
			//Se eliminan los personajes muertos
				for (Personaje p:aEliminar) {
					juego.eliminar(p);
					}
				aEliminar = new LinkedList<Personaje>();
				
			}// del while
		}// del run
	}// del thread