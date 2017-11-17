package GUI.Botones;

import Juego.Comprable;
import Objetos.Milhouse;

public class BotonMilhouse extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonMilhouse(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Milhouse();
		
	}
}