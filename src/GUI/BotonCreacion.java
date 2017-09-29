package GUI;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import Juego.Personaje;

public abstract class BotonCreacion extends JButton {
	

	public BotonCreacion(String a){
		super(new ImageIcon(FramePrincipal.class.getResource(a)));
	}
	
	public abstract Personaje factory();


}
