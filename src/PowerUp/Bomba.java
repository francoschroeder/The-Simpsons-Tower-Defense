package PowerUp;

public class Bomba extends PowerUp {
	
	public Bomba() {
		super("/sprites/powerUP/bomba.png");
		visitor = new VisitorBomba();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
}
