package GUI.Botones;

import Juego.Comprable;
import Juego.Personaje;
import Objetos.Milhouse;
import Personajes.Skinner;

public class BotonMilhouse extends BotonCreacion {
	
	public BotonMilhouse(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Milhouse();
		
	}
}