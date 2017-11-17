package GUI.Botones;

import Juego.Comprable;
import Personajes.Marge;

public class BotonMarge extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonMarge(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Marge();
		
	}
}