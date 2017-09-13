package Personajes;

import Juego.Aliado;

public class Marge extends Aliado {
	int VidaMax=80;
	int Ataque=20;
	int Rango=2;
	int Costo=50;
	public int getVidaMax() {
		return VidaMax;
	}
	public void setVidaMax(int vidaMax) {
		VidaMax = vidaMax;
	}
	public int getAtaque() {
		return Ataque;
	}
	public void setAtaque(int ataque) {
		Ataque = ataque;
	}
	public int getRango() {
		return Rango;
	}
	public void setRango(int rango) {
		Rango = rango;
	}
	public int getCosto() {
		return Costo;
	}
	public void setCosto(int costo) {
		Costo = costo;
	}


}
