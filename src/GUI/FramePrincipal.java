package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Juego.Personaje;
import Personajes.Homero;

public class FramePrincipal extends JFrame {
	private static final long seralVersionUID = 1L;
	
	private PanelMatriz matriz;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal frame = new FramePrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FramePrincipal() {
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134 , 794);
		matriz.setBorder(new EmptyBorder(5, 5, 5, 5));
		ImageIcon imag= new ImageIcon(getClass().getResource("/sprite/fondo.png"));
		matriz = new PanelMatriz(imag);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
	
	
	}

}
 
