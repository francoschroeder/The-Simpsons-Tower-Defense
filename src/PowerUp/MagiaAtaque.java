package PowerUp;

public class MagiaAtaque extends PowerUp{
	
	public MagiaAtaque() {
		super("/sprites/powerUP/bomba.png");
	}
   
	public VisitorPowerUp factory() {
		return new VisitorMAtaque();
	}
}
