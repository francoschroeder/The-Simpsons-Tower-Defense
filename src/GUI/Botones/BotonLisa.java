package GUI;

import javax.swing.JButton;

import Juego.Personaje;
import Personajes.Homero;

public class BotonLisa extends BotonCreacion {
	
	public BotonLisa(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Lisa();
		
	}
}
