package GUI.Botones;

import Juego.Comprable;
import Juego.Personaje;
import Objetos.BolaDeNieve;
import Personajes.Skinner;

public class BotonBolaNieve extends BotonCreacion {
	
	public  BotonBolaNieve(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new BolaDeNieve();
		
	}
}
