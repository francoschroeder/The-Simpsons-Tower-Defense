package GUI.Botones;

import Juego.Personaje;
import Personajes.Skinner;

public class BotonBolaNieve extends BotonCreacion {
	
	public  BotonBolaNieve(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new BolaDeNieve();
		
	}
}
