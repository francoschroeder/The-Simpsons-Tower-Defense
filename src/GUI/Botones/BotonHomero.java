package GUI.Botones;

 import javax.swing.JButton;

import Juego.Comprable;
import Juego.Personaje;
import Personajes.Homero;

public class BotonHomero extends BotonCreacion {
	
	public BotonHomero(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		
		return new Homero();
		
	}
}
