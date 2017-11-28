package Juego;

public class Normal extends State {
	private Personaje perso;
	
	public Normal(Personaje p) {
		perso = p;
	}
	
	public void reducirVida(int v) {
		if (v>perso.getVidaActual())
			perso.setVidaActual(0);
		else
			perso.setVidaActual(perso.getVidaActual()-v);
		
		perso.actualizarVida();
	}
	
	public void setCampoDeProteccion() {
		perso.getCampo().setVisible(false);
	}
}
