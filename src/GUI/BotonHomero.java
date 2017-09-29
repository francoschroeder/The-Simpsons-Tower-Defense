package GUI;

import javax.swing.JButton;

import Juego.Personaje;
import Personajes.Homero;

public class BotonHomero extends BotonCreacion {
	
	public BotonHomero(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Homero();
		
	}
}
