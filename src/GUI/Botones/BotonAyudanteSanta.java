package GUI.Botones;

import Juego.Comprable;
import Objetos.Selma;

public class BotonAyudanteSanta extends BotonCreacion {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonAyudanteSanta(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Selma();
		
	}
}