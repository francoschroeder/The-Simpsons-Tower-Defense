package GUI.Botones;

import Juego.Comprable;
import Objetos.Selma;

public class BotonSelma extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonSelma(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Selma();
		
	}
}