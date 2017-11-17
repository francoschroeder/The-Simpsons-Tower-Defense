package GUI.Botones;

import Juego.Comprable;
import Personajes.Bart;

public class BotonBart extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonBart(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Bart();
		
	}
}
