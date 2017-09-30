package GUI;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.MouseEvent;
import com.sun.javafx.collections.MappingChange.Map;

import GUI.Botones.BotonCreacion;
import GUI.Botones.BotonHomero;

import GUI.Botones.PersoSelec;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

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
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class GUIPrincipal extends JFrame {
	private PanelMapa panelMapa;
	private Juego j;
	private BotonCreacion homero;
	private BotonCreacion bart;
	private BotonCreacion lisa;
	private BotonCreacion marge;
	private BotonCreacion maggie;
	private BotonCreacion flander;
	private BotonCreacion milhouse;
	private JPanel panelBotones;
	private JPanel contentPane;
	private PersoSelec seleccionado;	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIPrincipal frame = new GUIPrincipal();
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
	public GUIPrincipal() {
		getContentPane().setBackground(new Color(154, 205, 50));
		getContentPane().setForeground(new Color(154, 205, 50));
		setBackground(new Color(154, 205, 50));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1134 , 794);
		setLocationRelativeTo(null);

	
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
				panelMapa.addMouseListener(new OyenteClick(panelMapa));
					
					
               
		
				
		//Crear juego
			j = new Juego(this);
			seleccionado = new PersoSelec(j);	
				
		//PAnel de los botones
				
		panelBotones = new JPanel();
		panelBotones.setBounds(177, 553, 757, 219);
		getContentPane().add(panelBotones);
		
	
		
		//Creo los botones y los agregos al panel
	
		homero = new BotonHomero("/sprites/homero/CaraHomeroBoton.jpg");
		homero.addActionListener(new OyenteBoton(homero));
		panelBotones.add(homero);
	
	
	}
	
	
	
	//oyente boton con Factory 
	
	private class OyenteBoton implements ActionListener{
		BotonCreacion b;
		
		public OyenteBoton(BotonCreacion b){
			this.b = b;
		}
		public void actionPerformed(ActionEvent e){
			Personaje p;
			seleccionado.serPersonaje(b);
			
		}
	}
	
	private class OyenteClick extends MouseAdapter{
		JPanel p;
		Personaje opa;
		public OyenteClick(JPanel p){
			this.p = p;
		}
		 public void mouseClicked(MouseEvent evento) {
			 Point punto = (p.getMousePosition());
			 System.out.println("se clic¡keoo");
			 opa = seleccionado.generarPersonaje(punto);
			 panelMapa.add(opa.getImagen());
		 	}
			 
			 public void mousePressed(MouseEvent evento) {
			  
			 }
			 
			 public void mouseReleased(MouseEvent evento) {
			  
			 }
			 
			 public void mouseExited(MouseEvent evento) {
			  
			 }
			 
			 public void mouseEntered(MouseEvent evento) {
			  
			 }
	
	}
	
	
}

