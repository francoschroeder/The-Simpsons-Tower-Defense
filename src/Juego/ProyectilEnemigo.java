package Juego;

public class ProyectilEnemigo extends Proyectil {
	
	public ProyectilEnemigo(int a) {
		ataque = a;
	}
	
	public void atacarAliado(Aliado a) {
		a.reducirVida(ataque);
	}
	
	public void atacarEnemigo(Enemigo e) {}
	
	public void atacarObjeto(Objeto o) {
		o.reducirVida(ataque);
	}
}
