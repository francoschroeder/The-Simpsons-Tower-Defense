package PowerUp;

public class ObjetoPrecioso extends PowerUp {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjetoPrecioso() {
		super("/sprites/powerUP/objetoPrecioso.jpg");
		visitor = new VisitorObjetoPrecioso();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
	
	public PowerUp clone() {
		return new ObjetoPrecioso();
	}
}