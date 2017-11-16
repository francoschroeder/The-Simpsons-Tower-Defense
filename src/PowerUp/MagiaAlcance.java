package PowerUp;

public class MagiaAlcance extends PowerUp{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MagiaAlcance() {
		super("/sprites/powerUP/magiaDeCuracion.png");
		visitor = new VisitorMAlcance();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
	
	public PowerUp clone() {
		System.out.println("Magia Alcance");
		return new MagiaAlcance();
	}
}
