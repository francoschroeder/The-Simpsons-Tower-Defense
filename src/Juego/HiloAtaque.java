package Juego;

import java.util.LinkedList;
import java.util.List;

import PowerUp.VisitorPowerUp;

public class HiloAtaque extends Thread {
	private Juego juego;
	private volatile boolean seguir, pausa;
	private HiloDisparo disparos;
	
	public HiloAtaque(Juego j, HiloDisparo h) {
		juego = j;
		disparos = h;
		seguir=true;
		pausa=false;
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
	
	public void run() {
		
		LinkedList<Comprable> aEliminar = new LinkedList<Comprable>();
		LinkedList<Enemigo> aEliminar2 = new LinkedList<Enemigo>();
		LinkedList<VisitorPowerUp> aEliminar3 = new LinkedList<VisitorPowerUp>();
		
		Personaje aAtacar;
		
		List<Comprable> listaAliados = juego.getAliados();
		List<Enemigo> listaEnemigos =  juego.getEnemigos();
		List<VisitorPowerUp> listaPowerUp = juego.getVisitorActivos();
		
		while (seguir) {
			while (!pausa) {
				synchronized (listaPowerUp) {
					for (VisitorPowerUp v:listaPowerUp) {
						v.pasarTiempo(1000);
						
						if (v.pasoTiempo())
							aEliminar3.add(v);
					}
				}
				
				for (VisitorPowerUp v:aEliminar3) {
					juego.eliminar(v);
				}
				
				synchronized (listaAliados) {
				for (Comprable a:listaAliados) {
					a.pasarTiempo(1000);
					a.actualizarVida();
					
					//Pide un blanco dentro del rango de ataque
					
					aAtacar = juego.getBlanco(a);
					
					//Ataca al blanco
					
					if (aAtacar!=null) {
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
			}
			
			}// del while
		}// del run
	}// del thread