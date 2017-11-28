package Juego;

import javax.swing.JLabel;

import PowerUp.VisitorPowerUp;

import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

public abstract class Personaje {
	protected int vidaMax;
	protected int vidaActual;
	protected int ataqueOriginal;
	protected int ataque;
	protected int rangoOriginal;
	protected int rango;
	protected int estadoActual;
	protected State[] estados;
	protected Proyectil miProyectil;
	protected Point posicion; // posicion en la matriz
	protected JLabel imagen;
	protected JLabel barraDeVida;
	protected JLabel campo;
	protected Map<String, ImageIcon> imActual;
	
	public static final int normal = 0;
	public static final int protegido = 1;
	public static final String neutral_key = "Neutral";
	public static final String shoot_key = "Shoot";
	
	public Personaje() {
		posicion = null;
		estadoActual = normal;
		estados = new State[2];
		estados[normal] = new Normal(this);
		estados[protegido] = new Protegido(this);
		
		imagen = new JLabel();
		imagen.setBounds(0, 0, 75, 75);
		barraDeVida = new JLabel();
		barraDeVida.setBackground(Color.GREEN);
		barraDeVida.setOpaque(true);
		campo = new JLabel();
		campo.setBounds(0, 0, 75, 75);
		campo.setVisible(false);
		imActual = new HashMap<String, ImageIcon>();
	}
	
	public JLabel getCampo() {
		return campo;
	}
	
	public int getCantCelda() {
		return 1;
	}

	public int getVidaActual() {
		return vidaActual;
	}

	public void setVidaActual(int vidaActual) {
		this.vidaActual = vidaActual;
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
	}
	
	public int getVidaMax() {
		return vidaMax;
	}

	public int getAtaque() {
		return ataque;
	}
	
	public int getAtaqueOriginal() {
		return ataqueOriginal;
	}
	
	public void setAtaque(int at) {
		ataque = at;
	}
	
	public int getRango() {
		return rango;
	}

	public int getRangoOriginal() {
		return rangoOriginal;
	}
	
	public abstract void serAtacado(Proyectil p);
	
	public void reducirVida(int v) {
		estados[estadoActual].reducirVida(v);
	}
	
	public boolean estaMuerto() {
		return vidaActual<=0;
	}
	
	public void cambiarEstado() {
		estadoActual = 1-estadoActual;
		estados[estadoActual].setCampoDeProteccion();
	}
	
	public abstract void afectar(VisitorPowerUp p);
	
	//Genera un disparo dirigido hacia el personaje p
	public abstract Disparo generarDisparo(Personaje p);
	
	public void actualizarVida() {
		if (vidaActual==vidaMax)
			barraDeVida.setBackground(Color.GREEN);
		else if ((vidaActual*75)/vidaMax<=40)
			barraDeVida.setBackground(Color.RED);
		else
			barraDeVida.setBackground(Color.YELLOW);
		
		barraDeVida.setBounds(getImagen().getX(), getImagen().getY(),(vidaActual*75)/vidaMax, 5);
	}
}
