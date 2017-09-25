package GUI;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.javafx.collections.MappingChange.Map;

import java.awt.event.ActionListener;
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
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FramePrincipal implements ActionListener {
	
	
	private static final long seralVersionUID = 1L;
	private JFrame FramePrincipal;
	private PanelMapa panelMapa;
	private Juego j;
	private JButton Homero;
	private JButton	Bart;
	private JButton Lisa;
	private JButton	Marge;
	private JButton Maggie;
	private JButton Flander;
	private JButton Milhouse;
	private JButton MatarSkinner;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FramePrincipal window = new FramePrincipal();
					window.FramePrincipal.setVisible(true);
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
		FramePrincipal = new JFrame();
		FramePrincipal.getContentPane().setBackground(new Color(154, 205, 50));
		FramePrincipal.getContentPane().setForeground(new Color(154, 205, 50));
		FramePrincipal.setBackground(new Color(154, 205, 50));
		
		FramePrincipal.getContentPane().setLayout(null);
		FramePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		FramePrincipal.setBounds(100, 100, 1134 , 794);
		FramePrincipal.setLocationRelativeTo(null);
		
		//Agrego y seteo panel que contiene en mapa en el frame.
		ImageIcon img= new ImageIcon(this.getClass().getResource("/sprites/fondo.png")); 
		panelMapa = new PanelMapa(img.getImage());
		panelMapa.setForeground(Color.WHITE);
		panelMapa.setLocation(185, 80);
		FramePrincipal.getContentPane().add(panelMapa);
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
		
		
		//CREACION DE BOTONES y PANEL.
		
		JPanel panel = new JPanel();
		panel.setBounds(185, 530, 749, 236);
		FramePrincipal.getContentPane().add(panel);
		
		Bart = new JButton("");
		
		Flander = new JButton("New button");
		
		Homero = new JButton(new ImageIcon(FramePrincipal.class.getResource("/sprites/homero/CaraHomeroBoton.jpg")));
		Homero.addActionListener(this);
		
		Milhouse = new JButton("New button");
		
		Lisa = new JButton("");
		
		MatarSkinner = new JButton("MatarSkinner\n");
		
		JButton Marge = new JButton("");
		
		JButton button_6 = new JButton("New button");
		
		JButton Maggie = new JButton("");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(12, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(Bart, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Homero, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Lisa, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Marge, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(Maggie, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(21))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(Flander, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(Milhouse, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(MatarSkinner, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 130, GroupLayout.PREFERRED_SIZE)
							.addGap(93))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Maggie, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(Marge, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(Lisa, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(Homero, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(Bart, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(button_6, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(MatarSkinner, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(Milhouse, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addComponent(Flander, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		 
		
		
		
		
		
		//Inicia el juego
		
		j = new Juego(this);
		
		
		}
/* Acciones de los botones*/
	
	public void actionPerformed(ActionEvent e){
		String evento=e.getActionCommand();
		/*Inicia la logica y pone todos los botones en visbles.*/
		if(e.getSource() == Homero){
			j.CrearHomero();
		}
		if(e.getSource() == Bart){
			j.CrearSkinner();
		}
		if(e.getSource() == MatarSkinner){
			j.eliminar();
		}
	
	}

	public PanelMapa getPanelMapa() {
		return panelMapa;
	
		
	}
}
 
