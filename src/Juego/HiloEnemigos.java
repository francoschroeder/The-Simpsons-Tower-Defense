package Juego;

import java.util.LinkedList;

public class HiloEnemigos extends Thread {
	private Juego j;
	private boolean seguir;
	
	public HiloEnemigos(Juego j) {
		this.j=j;
		seguir=true;
	}
	
	public void detener() {
		seguir=false;
	}
	
	public void run() {
		LinkedList<Enemigo> enemigos = j.getEnemigos();
		LinkedList<Enemigo> aEliminar = new LinkedList<Enemigo>();
		Personaje blanco;
		
		while(seguir) {
			for (Enemigo actual : enemigos) {
				if (!actual.estaMuerto()) {
				try {
					Thread.sleep(actual.getVelocidad()*10);
				} catch(Exception e) {}
				
				//Muevo al personaje
				actual.getImagen().setAlignmentX(actual.getImagen().getAlignmentX()+1);
				
				//Ataco (si se puede)
				blanco = j.getBlanco(actual);
				if (blanco!=null) {
					Proyectil pr = new ProyectilEnemigo(actual.getAtaque());
					blanco.serAtacado(pr);
				}
				} else {
					//Mando a eliminar, si es que está muerto
					aEliminar.add(actual);
				}
			}
			
			for (Enemigo e : aEliminar) {
				enemigos.remove(e);
			}
			
			aEliminar = new LinkedList<Enemigo>();
		}
	}
}
