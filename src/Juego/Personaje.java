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
	
	protected Point posicion; // posicion en la matriz
	protected JLabel imagen;
	protected Map<String, Icon> imActual;
	
	public static final String still_key = "Still";
	public static final String shoot_key = "Shoot";
	
	public Point getPosicion(){
		return posicion;
	}
	
	public void setPosicion(Point p){
		posicion = p;
		this.imagen.setBounds((int)this.posicion.getX()*75, (int)this.posicion.getY()*75, 75, 75);
	}

	public JLabel getImagen(){
		return imagen;
	}

	public void setImagen(String dir){
		this.imagen.setIcon(this.imActual.get(dir));
		this.imagen.setBounds(this.posicion.x, this.posicion.y, 75, 75);
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

	public abstract void serAtacado(Proyectil p);
	
	public void reducirVida(int v) {
		vidaActual-=v;
	}
}
