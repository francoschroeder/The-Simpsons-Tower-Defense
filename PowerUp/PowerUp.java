package PowerUp;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import GUI.GUIPrincipal;

public abstract class PowerUp extends JButton implements Cloneable {
	
	public PowerUp(String a){
		super(new ImageIcon(GUIPrincipal.class.getResource(a)));
		
	
	}
	
	public abstract VisitorPowerUp factory();
	
	public abstract Object clone();
	

}
