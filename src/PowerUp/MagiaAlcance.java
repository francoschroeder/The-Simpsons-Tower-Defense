package PowerUp;

public class MagiaAlcance extends PowerUp{
	
	public MagiaAlcance() {
		super("/sprites/powerUP/bomba.png");
	}
	
	public VisitorPowerUp factory() {
		return new VisitorMAlcance();
	}
}
