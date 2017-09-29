package GUI.Botones;

import javax.swing.JButton;

import Juego.Personaje;
import Personajes.Homero;

public class BotonMaggie extends BotonCreacion {
	
	public BotonMaggie(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Maggie();
		
	}
}
