package GUI.Botones;

import Juego.Comprable;
import Juego.Personaje;
import Objetos.Flanders;
import Personajes.Skinner;

public class BotonFlanders extends BotonCreacion {
	
	public BotonFlanders(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Flanders();
		
	}
}
