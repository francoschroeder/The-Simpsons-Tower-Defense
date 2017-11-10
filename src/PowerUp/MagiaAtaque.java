package PowerUp;

public class MagiaAtaque extends PowerUp{
	
	public MagiaAtaque() {
		super("/sprites/powerUP/bomba.png");
		visitor = new VisitorMAtaque();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
	
	public PowerUp clone() {
		return new MagiaAtaque();
	}
}

