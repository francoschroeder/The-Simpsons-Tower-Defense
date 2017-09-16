package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Juego.Personaje;
import Personajes.Homero;

public class FramePrincipal extends JFrame {
	private static final long seralVersionUID = 1L;
	
	private JPanel contentPane;

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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		
	
	
	}

}
 
