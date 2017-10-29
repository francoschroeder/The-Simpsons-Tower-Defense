package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;

import GUI.GUIPrincipal;
import GUI.PanelMapa;
import Personajes.Skinner;

public class HiloEnemigos extends Thread {
	private Juego j;
	private volatile boolean seguir;
	private Stack<Enemigo> enemigosPorSalir;
	private PanelMapa panel;
	private HiloDisparo disparos;
	public HiloEnemigos(Juego j, GUIPrincipal gui, HiloDisparo disparos) {
		this.j=j;
		seguir=true;
		panel = gui.getPanelMapa();
		this.disparos = disparos;
		enemigosPorSalir = new Stack<Enemigo>();
	
	}
	
	public void detener() {
		seguir=false;
	}
	
	public void crearEnemigosPorSalir() {
		Skinner s1 = new Skinner();
		s1.setPosicion(new Point(0, 0));
		s1.getImagen().setBounds(0*75+1, 0*75, 75, 75);
		panel.add(s1.getImagen());
		s1.getImagen().setVisible(false);
		enemigosPorSalir.push(s1);
		
		Skinner s2 = new Skinner();
		s2.setPosicion(new Point(0, 3));
		s2.getImagen().setBounds(0*75+1, 3*75, 75, 75);
		panel.add(s2.getImagen());
		s2.getImagen().setVisible(false);
		enemigosPorSalir.push(s2);
		
		Skinner s3 = new Skinner();
		s3.setPosicion(new Point(0, 5));
		s3.getImagen().setBounds(0*75+1, 5*75, 75, 75);
		panel.add(s3.getImagen());
		s3.getImagen().setVisible(false);
		enemigosPorSalir.push(s3);
		
		Skinner s4 = new Skinner();
		s4.setPosicion(new Point(0, 2));
		s4.getImagen().setBounds(0*75+1, 2*75, 75, 75);
		panel.add(s4.getImagen());
		s4.getImagen().setVisible(false);
		enemigosPorSalir.push(s4);
		
		Skinner s5 = new Skinner();
		s5.setPosicion(new Point(0, 5));
		s5.getImagen().setBounds(0*75+1, 5*75, 75, 75);
		panel.add(s5.getImagen());
		s5.getImagen().setVisible(false);
		enemigosPorSalir.push(s5);
		
	}
	
	public void run() {
		int cont=0;
		Enemigo aSalir;
		LinkedList<Enemigo> enemigos = j.getEnemigos();
		LinkedList<Enemigo> aEliminar = new LinkedList<Enemigo>();
		
		crearEnemigosPorSalir();
		
		aSalir = enemigosPorSalir.pop();
		aSalir.getImagen().setVisible(true);
		enemigos.add(aSalir);
		
		Personaje blanco;
		
		while(seguir) {
			
			for (Enemigo actual : enemigos) {
				if (!actual.estaMuerto()) {
				try {
					Thread.sleep((actual.getVelocidad()*50)/enemigos.size());
				} catch(Exception e) {}
				
				//Muevo al personaje
				if (((actual.getImagen().getLocation().getX()+30)%75)==0){ // llega al borde
					
					if (j.moverEnemigo(actual)){
					
							actual.getImagen().setBounds((int) (actual.getImagen().getLocation().getX()+1), (int) (actual.getImagen().getLocation().getY()), 75, 75);
					}
					else {
						System.out.println("punto enemigo: "+actual.getImagen().getLocation().getX());
					}
				}
				else{
					
					actual.getImagen().setBounds((int) (actual.getImagen().getLocation().getX()+1), (int) (actual.getImagen().getLocation().getY()), 75, 75);
				}
				//Ataco (si se puede)
				blanco = j.getBlanco(actual);
				if (blanco!=null) {
					actual.setImagen(Personaje.shoot_key);
					System.out.println("ataca");
					Proyectil pr = new ProyectilEnemigo(actual.getAtaque());
					Disparo bala = new Disparo(pr,blanco);
					panel.add(bala.getImagen());
					bala.getImagen().setBounds((int) actual.getImagen().getLocation().getX(), (int) actual.getImagen().getLocation().getY(), 75, 75);
				
					
				}
				} else {
					//Mando a eliminar, si es que esta muerto
					aEliminar.add(actual);
				}
			}
			
			for (Enemigo e : aEliminar) {
				enemigos.remove(e);
			}
			
			cont++;
			
			if (cont==80 && !enemigosPorSalir.isEmpty()) {
				aSalir = enemigosPorSalir.pop();
				aSalir.getImagen().setVisible(true);
				enemigos.add(aSalir);
				cont=0;
			}
			
			aEliminar = new LinkedList<Enemigo>();
		}
	}
}
