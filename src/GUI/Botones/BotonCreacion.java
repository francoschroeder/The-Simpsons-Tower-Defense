package GUI.Botones;

import javax.swing.ImageIcon;
import javax.swing.JButton;


import GUI.GUIPrincipal;
import Juego.Comprable;
import Juego.Personaje;

public abstract class BotonCreacion extends JButton {
	

	public BotonCreacion(String a){
		super(new ImageIcon(GUIPrincipal.class.getResource(a)));
	}
	
	public abstract Comprable factory();


}