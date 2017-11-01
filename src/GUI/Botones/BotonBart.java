package GUI.Botones;



import javax.swing.JButton;

import Juego.Comprable;
import Juego.Personaje;
import Personajes.Bart;
import Personajes.Homero;
import Personajes.Skinner;

public class BotonBart extends BotonCreacion {
	
	public BotonBart(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Bart();
		
	}
}
