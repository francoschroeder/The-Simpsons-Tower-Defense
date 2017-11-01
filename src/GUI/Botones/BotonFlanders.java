package GUI.Botones;

import Juego.Personaje;
import Personajes.Skinner;

public class BotonFlanders extends BotonCreacion {
	
	public BotonFlanders(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Flanders();
		
	}
}
