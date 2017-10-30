package GUI;

import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sun.glass.events.MouseEvent;
import com.sun.javafx.collections.MappingChange.Map;
import GUI.Botones.BotonMaggie;
import GUI.Botones.BotonMarge;
import GUI.Botones.BotonBart;
import GUI.Botones.BotonCreacion;
import GUI.Botones.BotonHomero;
import GUI.Botones.BotonLisa;
import GUI.Botones.BotonSkinner;
import GUI.Botones.Market;


import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseListener;

import Juego.Juego;
import Juego.Personaje;
import Personajes.Homero;
import Personajes.Skinner;

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
import java.awt.Toolkit;
import javax.swing.SwingConstants;

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
	private JLabel fondo;
	private JPanel panelBotones;
	private JPanel contentPane;
	private Market mercado;	
	private JButton skinner;
	private JButton BorrarSkinner;
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
	
	public Market getMarket(){
		return mercado;
	}

	/**
	 * Create the frame.
	 */
	public GUIPrincipal() {
		getContentPane().setEnabled(false);
		setTitle("Simpsons\n");
		getContentPane().setBackground(new Color(154, 205, 50));
		getContentPane().setForeground(new Color(154, 205, 50));
		setBackground(new Color(154, 205, 50));
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500 , 800);
		setLocationRelativeTo(null);
		
		// fondo del frame pricipal
		fondo = new JLabel();
		fondo.setBounds(0,0, 1500, 800);
		fondo.setIcon(new ImageIcon(this.getClass().getResource("/sprites/fondito.png")));
        getContentPane().add(fondo);

		//Agrego y seteo panel que contiene en mapa en el frame.
		
				ImageIcon img= new ImageIcon(this.getClass().getResource("/sprites/fondo.png")); 
				panelMapa = new PanelMapa(img.getImage());
				panelMapa.setForeground(Color.WHITE);
				panelMapa.setLocation(375, 75);;
				fondo.add(panelMapa);
				
		//Panel de los botones
				
		panelBotones = new JPanel();
		panelBotones.setBounds(370, 525, 760, 250);
		fondo.add(panelBotones);
		
	
		
		//Creo los botones y los agregos al panel
		
		homero = new BotonHomero("/sprites/homero/CaraHomeroBoton.jpg");
		homero.addActionListener(new OyenteBoton(homero));
		bart = new BotonBart("/sprites/bart/boton.png");
		bart.addActionListener(new OyenteBoton(bart));
		lisa = new BotonLisa("/sprites/lisa/boton.png");
		lisa.addActionListener(new OyenteBoton(lisa));
		maggie = new BotonMaggie("/sprites/maggie/boton.png");
		maggie.addActionListener(new OyenteBoton(maggie));
		marge = new BotonMarge("/sprites/marge/boton.png");
		marge.addActionListener(new OyenteBoton(marge));
		
		
		
		
		
		panelBotones.add(homero);
		panelBotones.add(bart);
		panelBotones.add(lisa);
		panelBotones.add(maggie);
		panelBotones.add(marge);
	
		
	}
	 // juego 
	
	public void setJuego(Juego j){
		this.j = j;
		
	}
	
	public void setMarket(Market mercado){
		this.mercado = mercado;
		panelMapa.setPerso(this.mercado);
		this.mercado.setPanel(panelMapa);
		System.out.println("aca se creo too");
	}
	
	//oyente boton con Factory 
	
	private class OyenteBoton implements ActionListener{
		BotonCreacion b;
		
		public OyenteBoton(BotonCreacion b){
			this.b = b;
		}
		public void actionPerformed(ActionEvent e){
			mercado.setBotonPersonaje(b);
			
		}
	}
	
	public PanelMapa getPanelMapa() {
		return panelMapa;
	}
	
}

