package Personajes;

import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Aliado;
import Juego.Personaje;

public class Marge extends Aliado {
	
	public Marge(){
		int VidaMax=80;
		int Ataque=20;
		int Rango=2;
		int Costo=50;
		ImageIcon img = new ImageIcon(this.getClass().getResource("/sprites/homero/homeroStill.gif"));
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/sprites/vida.png"));
		
		this.imagen = new JLabel();
		this.imagen.setIcon(img);
		this.imagen.setBounds(0, 0, 75, 75);
		
		this.barraDeVida = new JLabel();
		this.barraDeVida.setIcon(img2);
		this.actualizarVida();
		
		this.imActual = new HashMap<String, ImageIcon>();
		this.imActual.put(Personaje.still_key,new ImageIcon("/sprites/homero/homeroStill.gif"));
		this.imActual.put(Personaje.shoot_key,new ImageIcon("/sprites/homero/homeroAttack.gif"));
}	

}
