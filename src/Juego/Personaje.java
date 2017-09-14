package Juego;

import javax.swing.JLabel;

public abstract class Personaje extends JLabel {
	protected int vidaMax;
	protected int ataque;
	protected int rango;
	
	public int getVidaMax() {
		return vidaMax;
	}
	public void setVidaMax(int v) {
		vidaMax = v;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int at) {
		ataque = at;
	}
	public int getRango() {
		return rango;
	}
	
	public void atacar(Personaje p) {}
	
	public void reducirVida(int i) {
		vidaMax-=i;
	}
	
	
}
