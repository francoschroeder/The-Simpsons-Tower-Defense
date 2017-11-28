package PowerUp;

public class CampoProteccion extends PowerUp{
	
		private static final long serialVersionUID = 1L;

		public CampoProteccion() {
			super("/sprites/powerUP/campoDeProteccion.png");
			visitor = new VisitorCampoDeProteccion();
		}
		
		public VisitorPowerUp factory() {
			return visitor;
		}
		
		public PowerUp clone() {
			return new MagiaAtaque();
		}
	}