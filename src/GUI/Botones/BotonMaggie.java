package GUI.Botones;

import Juego.Comprable;
import Personajes.Maggie;

public class BotonMaggie extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonMaggie(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Maggie();
		
	}
}
