package GUI.Botones;

import Juego.Personaje;
import Personajes.Skinner;

public class BotonMilhouse extends BotonCreacion {
	
	public BotonMilhouse(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Milhouse();
		
	}
}