package GUI.Botones;

import GUI.Botones.BotonCreacion;
import Juego.Comprable;
import Personajes.Lisa;

public class BotonLisa extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonLisa(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Lisa();
		
	}
}
