package GUI.Botones;

import Juego.Comprable;
import Juego.Personaje;
import Objetos.AyudanteDeSanta;
import Personajes.Skinner;

public class BotonAyudanteSanta extends BotonCreacion {
	
	public BotonAyudanteSanta(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new AyudanteDeSanta();
		
	}
}