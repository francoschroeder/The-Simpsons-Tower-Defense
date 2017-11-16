package PowerUp;

public class MagiaAtaque extends PowerUp{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MagiaAtaque() {
		super("/sprites/powerUP/magiaDeAtaque.png");
		visitor = new VisitorMAtaque();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
	
	public PowerUp clone() {
		System.out.println("Magia ataque");
		return new MagiaAtaque();
	}
}

