package PowerUp;

public class Curacion extends PowerUp {
	
	public Curacion() {
		super("/sprites/powerUP/bomba.png");
	}
	
	public VisitorPowerUp factory() {
		return new VisitorCuracion();
	}
}
