package GUI.Botones;

import Juego.Comprable;
import Objetos.Martin;

public class BotonBolaNieve extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  BotonBolaNieve(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Martin();
		
	}
}
