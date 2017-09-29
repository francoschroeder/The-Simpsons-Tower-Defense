package GUI;

import javax.swing.JButton;

import Juego.Personaje;
import Personajes.Homero;

public class BotonMarge extends BotonCreacion {
	
	public BotonMarge(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Marge();
		
	}
}