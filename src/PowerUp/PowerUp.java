<<<<<<< HEAD
package PowerUp;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import GUI.GUIPrincipal;

public abstract class PowerUp extends JButton {

	private static final long serialVersionUID = 1L;
	VisitorPowerUp visitor;
	public PowerUp(String a){
		super(new ImageIcon(GUIPrincipal.class.getResource(a)));
		
	
	}
	
	public abstract VisitorPowerUp factory();
	
	@Override
	public abstract PowerUp clone();
}
=======
package PowerUp;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import GUI.GUIPrincipal;

public abstract class PowerUp extends JButton {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	VisitorPowerUp visitor;
	public PowerUp(String a){
		super(new ImageIcon(GUIPrincipal.class.getResource(a)));
	}
	
	public abstract VisitorPowerUp factory();
	
	@Override
	public abstract PowerUp clone();
}
>>>>>>> 795c5d543710cd249e722d2c84af666d97d29036
