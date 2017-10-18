package Personajes;

import java.util.HashMap;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Juego.Aliado;
import Juego.Personaje;

public class Lisa extends Aliado {
	public Lisa(){
		
	int VidaMax=25;
	int Ataque=10;
	int Rango=3;
	int Costo=25;
	
	
	ImageIcon img = new ImageIcon(this.getClass().getResource("/sprites/homero/homeroStill.gif"));
	
	this.imagen = new JLabel();
	this.imagen.setIcon(img);
	this.imagen.setBounds(0, 0, 75, 75);
	
	this.imActual = new HashMap<String, ImageIcon>();
	this.imActual.put(Personaje.still_key,new ImageIcon("/sprites/homero/homeroStill.gif"));
	this.imActual.put(Personaje.shoot_key,new ImageIcon("/sprites/homero/homeroAttack.gif"));
}

}
