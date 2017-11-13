package PowerUp;

public class Bomba extends PowerUp {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Bomba() {
		super("/sprites/powerUP/bomba.png");
		visitor = new VisitorBomba();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
	
	public PowerUp clone() {
		System.out.println("Bomba");
		return new Bomba();
	}
}
