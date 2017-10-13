package GUI.Botones;

import javax.swing.JButton;

import GUI.Botones.BotonCreacion;
import Juego.Personaje;
import Personajes.Homero;
import Personajes.Lisa;

public class BotonLisa extends BotonCreacion {
	
	public BotonLisa(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Lisa();
		
	}
}
