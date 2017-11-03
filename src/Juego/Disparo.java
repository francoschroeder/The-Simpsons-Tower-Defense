package Juego;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Disparo {
	protected Proyectil bala;
	protected Personaje inicio;
	protected Personaje destino;
	protected JLabel imagen;
	
	public Disparo(Proyectil bala, Personaje inicio, Personaje destino, String URL){
		this.bala = bala;
		this.destino = destino;
		this.inicio = inicio;
		ImageIcon img = new ImageIcon(this.getClass().getResource(URL));
		
		this.imagen = new JLabel();
		this.imagen.setIcon(img);
		this.imagen.setBounds(0, 0, 75, 75);
	}

	public Proyectil getBala() {
		return bala;
	}

	public Personaje getDestino() {
		return destino;
	}

	public JLabel getImagen() {
		return imagen;
	}

	public void setImagen(JLabel imagen) {
		this.imagen = imagen;
	}

	public Personaje getInicio() {
		return inicio;
	}

	public void setInicio(Personaje inicio) {
		this.inicio = inicio;
	}
	
	public void Atacar(){
		destino.serAtacado(bala);
	}

	public abstract void move();
	
	public boolean colisione(){
		if (((int) destino.getPosicion().getY()*75 < (int) this.getImagen().getLocation().getX()) && 
				(((int)destino.getPosicion().getY()*75)+75 > (int) this.getImagen().getLocation().getX())) {
			return true;
		}
		else return false;
	}
}
