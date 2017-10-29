package Juego;

import java.util.LinkedList;

public class HiloAliados extends Thread {
	private Juego juego;
	private volatile boolean seguir;
	
	public HiloAliados(Juego j) {
		juego = j;
		seguir=true;
	}
	
	public void detener() {
		seguir=false;
	}
	
	public void run() {
		LinkedList<Aliado> listaAliados = juego.getAliados();
		LinkedList<Aliado> aEliminar = new LinkedList<Aliado>();
		
		Personaje aAtacar;
		
		for (Aliado a:listaAliados) {
			try {
				Thread.sleep(75);
			} catch(InterruptedException e) {}
			
			if (a.estaMuerto())
				aEliminar.add(a);
			else {
				aAtacar = juego.getBlanco(a);
				
				if (aAtacar!=null) {
					
				}
			}
		}
		
		for (Aliado a:aEliminar) {
			listaAliados.remove(a);
		}
	}
}
