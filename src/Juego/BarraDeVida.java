package Juego;

import java.awt.Color;

import javax.swing.JLabel;

public class BarraDeVida extends JLabel{
	protected Personaje p;
	
	public BarraDeVida(Personaje p) {
		this.p = p;
		this.setBackground(Color.GREEN);
		this.setOpaque(true);
		this.setBounds(p.getImagen().getX(), p.getImagen().getY()-3, 75, 5);
	}
	
	public void actualizar() {
		this.setBounds(p.getImagen().getX(), p.getImagen().getY(),p.getVidaActual()*75/p.getVidaMax(), 5);
		
	}
	 
	
}
