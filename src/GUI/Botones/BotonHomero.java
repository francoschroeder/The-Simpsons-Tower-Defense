package GUI.Botones;

import Juego.Comprable;
import Personajes.Homero;

public class BotonHomero extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonHomero(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		
		return new Homero();
		
	}
}
