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
		LinkedList<Aliado> listaAliados = juego.getAliados();
		LinkedList<Enemigo> listaEnemigos = juego.getEnemigos();
		LinkedList<Personaje> aEliminar = new LinkedList<Personaje>();
		
		Proyectil pr;
		Disparo bala;
		Personaje aAtacar;
		while (seguir) {
			for (Aliado a:listaAliados) {
				try {
					Thread.sleep(75);
				} catch(InterruptedException e) {}
			
				if (a.estaMuerto())
					aEliminar.add(a);
				else {
					//Pide un blanco dentro del rango de ataque
					aAtacar = juego.getBlanco(a);
				
					//Ataca al blanco
					if (aAtacar!=null) {
						pr = new ProyectilAliado(a.getAtaque());
						bala = new Disparo(pr, a, aAtacar);
						disparos.agregarDisparo(bala);
					}
				}
			}
		
			//Se eliminan los personajes muertos
			for (Personaje p:aEliminar) {
				juego.eliminar(p);
			}
			
			aEliminar = new LinkedList<Personaje>();
		}
		
		for (Enemigo e:listaEnemigos) {
			try {
				Thread.sleep(75);
			} catch(InterruptedException ex) {}
		
			if (e.estaMuerto())
				aEliminar.add(e);
			else {
				//Pide un blanco dentro del rango de ataque
				aAtacar = juego.getBlanco(e);
			
				//Ataca al blanco
				if (aAtacar!=null) {
					pr = new ProyectilEnemigo(e.getAtaque());
					bala = new Disparo(pr, e, aAtacar);
					disparos.agregarDisparo(bala);
				}
			}
		}
	
		//Se eliminan los personajes muertos
		for (Personaje p:aEliminar) {
			juego.eliminar(p);
		}
		
		aEliminar = new LinkedList<Personaje>();
		}
}

