package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

import Messi.LionelMessi;
import Personajes.Barney;
import Personajes.MrBurns;
import Personajes.Nelson;
import Personajes.jefeGorgory;
import Personajes.Skinner;
import Personajes.Bob;

public class HiloEnemigos extends Thread {
	private Juego j;
	private volatile boolean seguir, pausa;
	private Stack<Enemigo> enemigosPorSalir;
	private LionelMessi lm;
	private int oleada, velAparicion, cont;
	
	public HiloEnemigos(Juego j, LionelMessi lm) {
		this.j=j;
		this.lm = lm;
		seguir=true;
		pausa=false;
		cont = 0;
		velAparicion = 50;
		enemigosPorSalir = crearEnemigosPorSalir();
	}
	
	public void pausar() {
		if (pausa)
			pausa = false;
		else
			pausa = true;
	}

	public void detener() {
		seguir = false;
		pausa = true;
	}
	
	public boolean hayEnemigosPorSalir() {
		return !enemigosPorSalir.isEmpty();
	}
	
	private Stack<Enemigo> crearEnemigosPorSalir() {
		
		LinkedList<Enemigo> enemigos = new LinkedList<Enemigo>();
		Stack<Enemigo> enemigosPorSalir = new Stack<Enemigo>();
		Random r = new Random();
		int cantPorSalir = r.nextInt(6) +10*j.getNivel();
		
		Enemigo s1 = new Skinner();
		Enemigo s2 = new jefeGorgory();
		Enemigo s3 = new MrBurns();
		Enemigo s4 = new Bob();
		Enemigo s5 = new Barney();
		Enemigo s6 = new Nelson();
		
		enemigos.add(s1);
		enemigos.add(s2);
		enemigos.add(s3);
		enemigos.add(s4);
		enemigos.add(s5);
		enemigos.add(s6);
		
		for(int i=0; i< cantPorSalir; i++) {
			Enemigo e = enemigos.get(r.nextInt(enemigos.size())).clone();
			Point pos = new Point(r.nextInt(6),0);
			e.setPosicion(pos);
			enemigosPorSalir.push(e);
		}
		
		oleada = enemigosPorSalir.size()/2;		//a la mitad de la pila termina una oleada
		
		return enemigosPorSalir;
	}
	
	public void run() {
		Enemigo aSalir;
		aSalir = enemigosPorSalir.pop();
		j.agregarPersonaje(aSalir, aSalir.getPosicion());
			
		List<Enemigo> enemigos = j.getEnemigos();
		
		while(seguir) {
			while(!pausa) {
				
			 if(!enemigos.isEmpty()) {
				 
				for (Enemigo actual : enemigos) {
					if (!actual.estaMuerto()) {
					
						if (j.hayRalentizador(actual)) 
							actual.ralentizar();
						else
							actual.desralentizar();
						
					if ((int) actual.getPosicion().getY()==9) {
						j.restarVidas();
						actual.setVidaActual(0);
					} else {
						//Muevo al personaje
						if (((actual.getPosicion().getY()+1)*75)-(actual.getImagen().getX()+5)<=5) { // llega al borde
					
							if (j.moverEnemigo(actual)){
							
								actual.avanzar();
							}
						} else {
							actual.avanzar();
						 }
					  } 
				   }
				}
			 }
			
			 try {
				Thread.sleep(200);
			} catch(Exception e) {}
			 
			cont++;
			
			if (oleada==enemigosPorSalir.size()) {
				velAparicion=200;
				
				oleada=-1;
			}
			
			if (cont==velAparicion  && !enemigosPorSalir.isEmpty()) {
				aSalir = enemigosPorSalir.pop();
				j.agregarPersonaje(aSalir, aSalir.getPosicion());
				cont=0;
				velAparicion=50;
				velAparicion = (int) velAparicion/j.getNivel();
				if(velAparicion <= 20) {
					velAparicion = 20;
				}
			}

			
			
			if (enemigosPorSalir.isEmpty()) {
				j.pasarDeNivel(this);
				lm.pasarNivel();
				enemigosPorSalir = crearEnemigosPorSalir();
				cont = 0;
			}
			
			if (j.perdio()) {
				lm.perder();
			}
			}
			
		}
	}
}

