package Objetos;

import Juego.Disparo;
import Juego.DisparoAliado;
import Juego.Objeto;
import Juego.Personaje;
import Juego.ProyectilAliado;

public abstract class Comprable extends Personaje{
	protected int costo;
	
	public Disparo generarDisparo(Personaje p) {
		return new DisparoAliado(new ProyectilAliado(ataque), this, p);
	}
	
	
}
