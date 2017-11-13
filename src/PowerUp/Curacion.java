package PowerUp;

public class Curacion extends PowerUp {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Curacion() {
		super("/sprites/powerUP/curacion.png");
		visitor = new VisitorCuracion();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
	
	public PowerUp clone() {
		System.out.println("Curacion");
		return new Curacion();
	}
}

