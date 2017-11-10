package Juego;

import javax.swing.JLabel;

import PowerUp.VisitorPowerUp;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class Personaje {
	protected static int vidaMax;
	protected int vidaActual;
	protected int ataque;
	protected int rango;
	protected Proyectil miProyectil;
	
	protected Point posicion; // posicion en la matriz
	protected JLabel imagen;
	protected JLabel barraDeVida;
	protected Map<String, ImageIcon> imActual;
	
	public static final String neutral_key = "Neutral";
	public static final String shoot_key = "Shoot";
	
	public Personaje() {
		posicion = null;
		
		imagen = new JLabel();
		imagen.setBounds(0, 0, 75, 75);
		
		barraDeVida = new JLabel();
		barraDeVida.setBackground(Color.GREEN);
		barraDeVida.setOpaque(true);
		actualizarVida();
		
		imActual = new HashMap<String, ImageIcon>();
	}
	
	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
	}

	public static void setVidaMax(int vidaMax) {
		Personaje.vidaMax = vidaMax;
	}

	public void setRango(int rango) {
		this.rango = rango;
	}

	public Point getPosicion(){
		return posicion;
	}
	
	public void setPosicion(Point p){
		posicion = p;
		this.imagen.setBounds((int)this.posicion.getX()*75, (int)this.posicion.getY()*75, 75, 75);
	}

	public JLabel getImagen() {
		return imagen;
	}
	
	public JLabel getBarraDeVida() {
		return barraDeVida;
	}

	public void setImagen(String dir){
		imagen.setIcon(imActual.get(dir));
		actualizarVida();
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
		if (v>vidaActual)
			vidaActual=0;
		else
			vidaActual-=v;
		
		System.out.println("vida: "+vidaActual);
		
		actualizarVida();
	}
	
	public boolean estaMuerto() {
		return vidaActual<=0;
	}
	
	public abstract void afectar(VisitorPowerUp p);
	
	//Genera un disparo dirigido hacia el personaje p
	public abstract Disparo generarDisparo(Personaje p);
	
	public void actualizarVida() {
		barraDeVida.setBounds((int) imagen.getLocation().getX(), (int) imagen.getLocation().getY()-10, vidaActual*(vidaMax/40), 5);
	}
	
	
}
