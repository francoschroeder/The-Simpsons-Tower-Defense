package Personajes;

import Juego.Aliado;

public class Lisa extends Aliado {
	
	int VidaMax=25;
	int Ataque=10;
	int Rango=3;
	int Costo=25;
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
