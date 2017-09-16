package Juego;

import javax.swing.JLabel;
import javax.swing.Icon;
import java.awt.Point;
import java.util.Map;

public abstract class Personaje{
	protected static int vidaMax;
	protected int vidaActual;
	protected int ataque;
	protected int rango;
	
	protected Point posicion;
	protected JLabel imagen;
	protected Map<String, Icon> imActual;
	
	public static  final String still_key = "Still";
	public static final String shoot_key = "Shoot";
	
	public Point getPosiscion(){
		return posicion;
	}
	
	public void setPosicion(Point p){
		posicion = p;
	}

	public JLabel getImagen(){
		return imagen;
	}

	public void setImagen(String dir){
		this.imagen.setIcon(this.imActual.get(dir));
		this.imagen.setBounds(this.posicion.x, this.posicion.y, width, height);
	}
	
	public int getVidaMax() {
		return vidaMax;
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
