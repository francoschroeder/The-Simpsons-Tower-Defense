package GUI;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.collections.MappingChange.Map;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import Juego.Juego;
import Juego.Personaje;
import Personajes.Homero;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

public class FramePrincipal extends JFrame {
	private static final long seralVersionUID = 1L;
	
	private PanelMapa panelMapa;
	private Juego j;
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
		getContentPane().setBackground(new Color(154, 205, 50));
		getContentPane().setForeground(new Color(154, 205, 50));
		setBackground(new Color(154, 205, 50));
		
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134 , 794);
		this.setLocationRelativeTo(null);
		//Agrego y seteo panel que contiene en mapa en el frame.
		ImageIcon img= new ImageIcon(this.getClass().getResource("/sprites/fondo.png")); 
		panelMapa = new PanelMapa(img.getImage());
		panelMapa.setForeground(Color.WHITE);
		panelMapa.setLocation(185, 80);
		getContentPane().add(panelMapa);
		GroupLayout gl_panelMapa = new GroupLayout(panelMapa);
		gl_panelMapa.setHorizontalGroup(
			gl_panelMapa.createParallelGroup(Alignment.LEADING)
				.addGap(0, 749, Short.MAX_VALUE)
		);
		gl_panelMapa.setVerticalGroup(
			gl_panelMapa.createParallelGroup(Alignment.LEADING)
				.addGap(0, 446, Short.MAX_VALUE)
		);
		panelMapa.setLayout(gl_panelMapa);
		
		JPanel panel = new JPanel();
		panel.setBounds(185, 605, 749, 161);
		getContentPane().add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 749, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 161, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		 //Inicia el juego
		
		j = new Juego(this);
		
		
		}

	public PanelMapa getPanelMapa() {
		return panelMapa;
	}


	
}
 
