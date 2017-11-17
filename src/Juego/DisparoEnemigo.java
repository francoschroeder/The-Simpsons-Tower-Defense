package Juego;

public class DisparoEnemigo  extends Disparo{
	
	public DisparoEnemigo(Proyectil bala,Personaje inicio,Personaje destino){
		super(bala,inicio,destino, "/sprites/homero/bola.gif");
		
	}
	public void move(){
		getImagen().setLocation((int)getImagen().getLocation().getX()+1,(int) getImagen().getLocation().getY());
	}
	
	public boolean colisione(){
		if ((imagen.getLocation().getX() > (destino.getImagen().getLocation().getX()+4)))  {
			return true;
		}
		else return false;
		}
}