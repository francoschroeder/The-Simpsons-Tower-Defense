package GUI;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import com.sun.prism.Graphics;
import com.sun.prism.Image;

public class PanelMatriz extends JPanel  {
	private java.awt.Image background;
	 
	// Metodo que es llamado automaticamente por la maquina virtual Java cada vez que repinta
	public void paintComponent(Graphics g) {
 
		/* Obtenemos el tamaño del panel para hacer que se ajuste a este
		cada vez que redimensionemos la ventana y se lo pasamos al drawImage */
		int width = this.getSize().width;
		int height = this.getSize().height;
 
		// Mandamos que pinte la imagen en el panel
		if (this.background != null) {
			((java.awt.Graphics) g).drawImage(this.background, 0, 0, width, height, null);
		}
 
		super.paintComponent((java.awt.Graphics) g);
	}
 
	// Metodo donde le pasaremos la dirección de la imagen a cargar.
	public void setBackground(String imagePath) {
		
		// Construimos la imagen y se la asignamos al atributo background.
		this.setOpaque(false);
		this.background = new ImageIcon(imagePath).getImage();
		repaint();
	}
	
}
