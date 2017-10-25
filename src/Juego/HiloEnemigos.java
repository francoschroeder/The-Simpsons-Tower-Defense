package Juego;

import java.util.LinkedList;
import java.util.Stack;

import Personajes.Skinner;

public class HiloEnemigos extends Thread {
	private Juego j;
	private boolean seguir;
	private Stack<Enemigo> enemigosPorSalir;
	
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
		
		enemigosPorSalir = new Stack<Enemigo>();
		enemigosPorSalir.push(new Skinner());
		enemigosPorSalir.push(new Skinner());
		enemigosPorSalir.push(new Skinner());
		enemigosPorSalir.push(new Skinner());
		enemigosPorSalir.push(new Skinner());
		
		enemigos.add(enemigosPorSalir.pop());
		
		Personaje blanco;
		
		while(seguir) {
			int cont=0;
			
			for (Enemigo actual : enemigos) {
				if (!actual.estaMuerto()) {
				try {
					Thread.sleep(actual.getVelocidad()*10);
				} catch(Exception e) {}
				
				//Muevo al personaje
				if ((actual.getImagen().getAlignmentX()%75)==0)
					if (j.moverEnemigo(actual))
							actual.getImagen().setAlignmentX(actual.getImagen().getAlignmentX()+1);
					else {}
				else
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
			
			cont++;
			
			if (cont==80) {
				enemigos.add(enemigosPorSalir.pop());
				cont=0;
			}
			
			aEliminar = new LinkedList<Enemigo>();
		}
	}
}
