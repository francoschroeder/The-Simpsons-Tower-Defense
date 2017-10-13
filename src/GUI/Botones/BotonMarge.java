package GUI.Botones;

import javax.swing.JButton;

import Juego.Personaje;
import Personajes.Homero;
import Personajes.Marge;

public class BotonMarge extends BotonCreacion {
	
	public BotonMarge(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Marge();
		
	}
}