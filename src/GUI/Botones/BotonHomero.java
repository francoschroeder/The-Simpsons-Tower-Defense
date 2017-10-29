package GUI.Botones;

 import javax.swing.JButton;
import Juego.Personaje;
import Personajes.Homero;

public class BotonHomero extends BotonCreacion {
	
	public BotonHomero(String a){
		
		super(a);
		
		
	}
	
	public Personaje factory(){
		System.out.println("crea a homero");
		return new Homero();
		
	}
}
