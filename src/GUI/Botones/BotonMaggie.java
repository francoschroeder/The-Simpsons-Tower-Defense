package GUI.Botones;

import javax.swing.JButton;

import Juego.Comprable;
import Juego.Personaje;
import Personajes.Homero;
import Personajes.Maggie;

public class BotonMaggie extends BotonCreacion {
	
	public BotonMaggie(String a){
		
		super(a);
		
		
	}
	
	public Comprable factory(){
		return new Maggie();
		
	}
}
