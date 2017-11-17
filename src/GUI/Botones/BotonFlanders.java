package GUI.Botones;

import Juego.Comprable;
import Objetos.Flanders;

public class BotonFlanders extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonFlanders(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Flanders();
		
	}
}
