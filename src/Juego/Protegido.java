package Juego;

public class Protegido extends State {
	private Personaje perso;
	
	public Protegido(Personaje p) {
		perso = p;
	}
	
	public void reducirVida(int v) {}
	
	public void setCampoDeProteccion() {
		perso.getCampo().setVisible(true);
	}
}
