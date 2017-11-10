package PowerUp;

public class Curacion extends PowerUp {
	
	public Curacion() {
		super("/sprites/powerUP/bomba.png");
	}
	
	public PowerUp clone(){
		Object clone = super("/sprites/powerUP/bomba.png");
		return clone;
	}
}
