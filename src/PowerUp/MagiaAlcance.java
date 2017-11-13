package PowerUp;

public class MagiaAlcance extends PowerUp{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MagiaAlcance() {
		super("/sprites/powerUP/bomba.png");
		visitor = new VisitorMAlcance();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
	
	public PowerUp clone() {
		return new MagiaAlcance();
	}
}
