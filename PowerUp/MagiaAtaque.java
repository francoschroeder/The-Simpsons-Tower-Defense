package PowerUp;

public class MagiaAtaque extends PowerUp{
	
	public MagiaAtaque() {
		super("/sprites/powerUP/bomba.png");
	}
   
	public VisitorPowerUp factory() {
		return new VisitorMAtaque();
	}
	
	public PowerUp clone(){
		Object clone = super("/sprites/powerUP/bomba.png");
		return clone;
	}
}
