package PowerUp;

public class Curacion extends PowerUp {
	
	public Curacion() {
		super("/sprites/powerUP/bomba.png");
		visitor = new VisitorCuracion();
	}
	
	public VisitorPowerUp factory() {
		return visitor;
	}
}

