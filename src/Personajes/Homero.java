package Personajes;

import Juego.Aliado;

public class Homero extends Aliado {
	int VidaMax=25;
	int Ataque=4;
	int Rango=3;
	int Costo=10;
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
