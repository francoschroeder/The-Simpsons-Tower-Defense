package PowerUp;

public class Bomba extends PowerUp {
	
	public Bomba() {
		super("/sprites/powerUP/bomba.png");
	}

	public VisitorPowerUp factory() {
		return new VisitorBomba();
	}
	
	public PowerUp clone(){
		Object clone =  super("/sprites/powerUP/bomba.png");
		return clone;		
	}
}
