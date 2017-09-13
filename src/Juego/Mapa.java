package Juego;

public interface Mapa {
	public void generar();
	public Personaje getBlanco (int x, int y, int alcance);
}
