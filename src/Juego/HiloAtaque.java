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
		List<Objeto> listaObjetos = juego.getObjetos();
		
		while (seguir) {
			
			synchronized (listaAliados) {
				for (Comprable a:listaAliados) {
					
					//Pide un blanco dentro del rango de ataque
					
					aAtacar = juego.getBlanco(a);
					
					//Ataca al blanco
					
					if (aAtacar!=null) {
						
							
							System.out.println("Dispara Aliado");
							a.setImagen(Personaje.shoot_key); // Cambia imagen a disparo;
							disparos.agregarDisparo(a.generarDisparo(aAtacar));
							
							}
					if (a.estaMuerto()) {
						aEliminar.add(a);
						} else {
						a.setImagen(Personaje.neutral_key);
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
						e.setImagen(Personaje.shoot_key); // Cambia imagen a disparo;
						disparos.agregarDisparo(e.generarDisparo(aAtacar));
						}  
						
						
				if (e.estaMuerto()) {
					aEliminar2.add(e);
					} else {
					e.setImagen(Personaje.neutral_key);
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
			
			if (!listaObjetos.isEmpty()) 
				for (Objeto o:listaObjetos) {
					o.pasarTiempo(1000);
					
					if (o.pasoTiempo())
						juego.eliminar(o);
				}
			}// del while
		}// del run
	}// del thread