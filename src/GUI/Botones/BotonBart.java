package GUI;

import javax.swing.JButton;

import Juego.Personaje;
import Personajes.Homero;

public class BotonBart extends BotonCreacion {
	
	public BotonBart(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Bart();
		
	}
}
