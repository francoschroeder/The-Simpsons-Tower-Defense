package GUI.Botones;

import Juego.Comprable;
import Objetos.Martin;

public class BotonMartin extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  BotonMartin(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Martin();
		
	}
}
