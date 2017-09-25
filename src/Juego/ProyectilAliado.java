package Juego;

public class ProyectilAliado extends Proyectil {
	
	public ProyectilAliado(int a) {
		ataque = a;
	}
	
	public void atacarAliado(Aliado a) {}
	
	public void atacarEnemigo(Enemigo e) {
		e.reducirVida(ataque);
	}
	
	public void atacarObjeto(Objecto o) {
		o.reducirVida(ataque);
	}
}
