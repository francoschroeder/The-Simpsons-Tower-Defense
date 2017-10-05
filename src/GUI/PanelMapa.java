package GUI;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

import com.sun.javafx.scene.paint.GradientUtils.Point;
import java.awt.geom.Point2D;
import GUI.Botones.BotonCreacion;
import GUI.Botones.PersoSelec;
import Juego.Personaje;
 
/**
 * 
 * Clase que extiende de JPanel y permite poner una imagen como fondo.
 * 
 * @author Guille Rodriguez Gonzalez ( http://www.driverlandia.com )
 * @version 1.0 | 05-2014
 * 
 */
 
public class PanelMapa extends JPanel {
	PersoSelec selec;
	Personaje perso;
	Point puntoNuevo;
	
	public void setPerso(PersoSelec p){
		selec = p;
	}
 
	private static final long serialVersionUID = 1L;
	// Atributo que guardara la imagen de Background que le pasemos.
	private Image background;
			
	// Metodo donde le pasaremos la dirección de la imagen a cargar.
		public PanelMapa(Image g) {
			
			// Construimos la imagen y se la asignamos al atributo background.
			this.setOpaque(false);
			this.background = g;
			Dimension dimension = new Dimension(background.getWidth(null),background.getHeight(null));
			this.setSize(dimension);
			this.setMinimumSize(dimension);
			this.setMaximumSize(dimension);
			this.setLayout(null);
			this.setPreferredSize(dimension);
			addMouseListener(new OyentePanel(this));
		
		
		
		}	
	// Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
	public void paintComponent(Graphics g) {
 
		/* Obtenemos el tamaño del panel para hacer que se ajuste a este
		cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		// Mandamos que pinte la imagen en el panel
	  g.drawImage(this.background, 0, 0, width, height, null);
		
	}
	
	private class OyentePanel implements MouseListener{
		PanelMapa b;
		
		public OyentePanel(PanelMapa b){
			this.b = b;
		}
		 public void mousePressed(MouseEvent e) {
			selec.generarPersonaje(e.getPoint());
			System.out.println("holaa");
			 
		    }

		    public void mouseReleased(MouseEvent e) {
		   
		    }

		    public void mouseEntered(MouseEvent e) {
		      
		    }

		    public void mouseExited(MouseEvent e) {
		       		    }

		    public void mouseClicked(MouseEvent e) {
		       
		    }
		}
}
