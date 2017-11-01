package GUI.Botones;

import Juego.Personaje;
import Personajes.Skinner;

public class BotonAyudanteSanta extends BotonCreacion {
	
	public BotonAyudanteSanta(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new AyudanteDeSanta();
		
	}
}