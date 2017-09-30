package GUI.Botones;

 import javax.swing.JButton;
import Juego.Personaje;
import Personajes.Homero;
import Personajes.Skinner;

public class BotonSkinner extends BotonCreacion {
	
	public BotonSkinner(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		return new Skinner();
		
	}
}
