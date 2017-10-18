package Juego;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Stack;

import java.awt.Rectangle;

import GUI.GUIPrincipal;
import GUI.PanelMapa;
import Personajes.Skinner;

public class HiloEnemigos extends Thread {
	private Juego j;
	private boolean seguir;
	private Stack<Enemigo> enemigosPorSalir;
	private PanelMapa panel;
	
	public HiloEnemigos(Juego j, GUIPrincipal gui) {
		this.j=j;
		seguir=true;
		enemigosPorSalir = new Stack<Enemigo>();
		panel = gui.getPanelMapa();
	}
	
	public void detener() {
		seguir=false;
	}
	
	public void cargarPilaEnemigos() {
		Skinner s1 = new Skinner();
		s1.setPosicion(new Point(0, 0));
		s1.getImagen().setBounds(0*75,  0*75, 75, 75);
		s1.getImagen().setVisible(false);
		panel.add(s1.getImagen());
		
		Skinner s2 = new Skinner();
		s2.setPosicion(new Point(0, 3));
		s2.getImagen().setBounds(0*75,  3*75, 75, 75);
		s2.getImagen().setVisible(false);
		panel.add(s2.getImagen());
		
		Skinner s3 = new Skinner();
		s3.setPosicion(new Point(0, 5));
		s3.getImagen().setBounds(0*75,  5*75, 75, 75);
		s3.getImagen().setVisible(false);
		panel.add(s3.getImagen());
		
		Skinner s4 = new Skinner();
		s4.setPosicion(new Point(0, 2));
		s4.getImagen().setBounds(0*75,  2*75, 75, 75);
		s4.getImagen().setVisible(false);
		panel.add(s4.getImagen());
		
		Skinner s5 = new Skinner();
		s5.setPosicion(new Point(0, 4));
		s5.getImagen().setBounds(0*75,  4*75, 75, 75);
		s5.getImagen().setVisible(false);
		panel.add(s5.getImagen());
		
		enemigosPorSalir.push(s1);
		enemigosPorSalir.push(s2);
		enemigosPorSalir.push(s3);
		enemigosPorSalir.push(s4);
		enemigosPorSalir.push(s5);
	}
	
	public void run() {
		int cont=0;
		LinkedList<Enemigo> enemigos = j.getEnemigos();
		LinkedList<Enemigo> aEliminar = new LinkedList<Enemigo>();
		Enemigo aSalir;
		
		cargarPilaEnemigos();
		
		aSalir = enemigosPorSalir.pop();
		aSalir.getImagen().setVisible(true);
		enemigos.add(aSalir);
		
		Personaje blanco;
		
		while(seguir) {
			
			for (Enemigo actual : enemigos) {
				if (!actual.estaMuerto()) {
				try {
					Thread.sleep(actual.getVelocidad()*10);
				} catch(Exception e) {}
				
				//Muevo al personaje
				/*if ((((int) actual.getImagen().getLocation().getX())%75)==0)
					j.moverEnemigo(actual);
				else*/
					actual.getImagen().setBounds(((int) actual.getImagen().getLocation().getX())+1, (int) actual.getImagen().getLocation().getY(), 75, 75);
					
				
				//Ataco (si se puede)
				blanco = j.getBlanco(actual);
				if (blanco!=null) {
					//Rectangle r = actual.getImagen().getBounds();
					actual.setImagen(actual.shoot_key);
					//actual.getImagen().setBounds(r);
					//actual.getImagen().setVisible(true);
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
