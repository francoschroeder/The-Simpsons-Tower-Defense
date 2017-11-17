package GUI.Botones;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import GUI.GUIPrincipal;
import Juego.Comprable;

public abstract class BotonCreacion extends JButton {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BotonCreacion(String a){
		super(new ImageIcon(GUIPrincipal.class.getResource(a)));
	}
	
	public abstract Comprable factory();


}