package GUI.Botones;



import javax.swing.JButton;

import Juego.Personaje;
import Personajes.Bart;
import Personajes.Homero;
import Personajes.Skinner;

public class BotonBart extends BotonCreacion {
	
	public BotonBart(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Bart();
		
	}
}
