package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Botones.BotonMaggie;
import GUI.Botones.BotonMarge;
import GUI.Botones.BotonMilhouse;
import GUI.Botones.BotonSelma;
import GUI.Botones.BotonBart;
import GUI.Botones.BotonMartin;
import GUI.Botones.BotonCreacion;
import GUI.Botones.BotonFlanders;
import GUI.Botones.BotonHomero;
import GUI.Botones.BotonLisa;
import GUI.Botones.Market;

import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Font;

public class GUIPrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PanelMapa panelMapa;
	private JLabel fondo;
	private JPanel panelBotones;
	private Market mercado;	
	private JTextField monedas;
	private JTextField puntos;
	private JTextField nivel;
	private JTextField vidas;
	private JTextField oleada;
	private JTextField oleadaPo;
	
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
		setBounds(100, 100, 1206 , 734);
		setLocationRelativeTo(null);
		
		ImageIcon img= new ImageIcon(this.getClass().getResource("/sprites/fondo.png"));
		
		oleadaPo = new JTextField();
		oleadaPo.setEditable(false);
		oleadaPo.setFont(new Font("Kozuka Mincho Pr6N", Font.PLAIN, 24));
		oleadaPo.setText("Se aproxima otra..");
		oleadaPo.setBackground(Color.YELLOW);
		oleadaPo.setBounds(6, 236, 237, 67);
		getContentPane().add(oleadaPo);
		oleadaPo.setColumns(10);
		oleadaPo.setVisible(false);
		
		
		
		oleada = new JTextField();
		oleada.setEditable(false);
		oleada.setBackground(Color.YELLOW);
		oleada.setFont(new Font("Kozuka Mincho Pr6N", Font.PLAIN, 24));
		oleada.setToolTipText("");
		oleada.setText("Termino la Oleada ");
		oleada.setBounds(6, 140, 249, 59);
		getContentPane().add(oleada);
		oleada.setColumns(10);
		oleada.setVisible(false);
		
		panelMapa = new PanelMapa(img.getImage());
		panelMapa.setSize(750, 450);
		getContentPane().add(panelMapa);
		panelMapa.setForeground(Color.WHITE);
		panelMapa.setLocation(267, 6);
		
		nivel = new JTextField();
		nivel.setBackground(Color.YELLOW);
		nivel.setForeground(Color.BLACK);
		nivel.setColumns(10);
		nivel.setBounds(1029, 556, 157, 50);
		getContentPane().add(nivel);
		
		
		
		vidas = new JTextField();
		vidas.setBackground(Color.YELLOW);
		vidas.setText("Vidas: ");
		vidas.setForeground(Color.BLACK);
		vidas.setColumns(10);
		vidas.setBounds(1029, 618, 157, 50);
		getContentPane().add(vidas);
		
		monedas = new JTextField();
		monedas.setBackground(Color.YELLOW);
		getContentPane().add(monedas);
		monedas.setBounds(1029, 494, 157, 50);
		monedas.setColumns(10);
		monedas.setEditable(false);
		
		puntos = new JTextField();
		puntos.setBackground(Color.YELLOW);
		puntos.setForeground(Color.BLACK);
		puntos.setBounds(1029, 432, 157, 50);
		getContentPane().add(puntos);
		puntos.setColumns(10);
		
		
		
		//Panel de los botones
		
		panelBotones = new JPanel();
		getContentPane().add(panelBotones);
		panelBotones.setBounds(257, 455, 760, 250);
		
	
		
		//Creo los botones y los agregos al panel
		
		BotonCreacion homero = new BotonHomero("/sprites/homero/CaraHomeroBoton.jpg");
		homero.setToolTipText("");
		homero.setText("30 Monedas");
		homero.addActionListener(new OyenteBoton(homero));
		BotonCreacion bart = new BotonBart("/sprites/bart/boton.png");
		bart.setMinimumSize(new Dimension(90, 60));
		bart.setText("10 Monedas");
		bart.addActionListener(new OyenteBoton(bart));
		BotonCreacion lisa = new BotonLisa("/sprites/lisa/boton.png");
		lisa.setText("25 Monedas");
		lisa.addActionListener(new OyenteBoton(lisa));
		BotonCreacion maggie = new BotonMaggie("/sprites/maggie/boton.png");
		maggie.setText("60 Monedas");
		maggie.addActionListener(new OyenteBoton(maggie));
		BotonCreacion marge = new BotonMarge("/sprites/marge/boton.png");
		marge.setText("40 Monedas");
		marge.addActionListener(new OyenteBoton(marge));
		BotonCreacion milhouse = new BotonMilhouse("/sprites/milhouse/boton.png");
		milhouse.setText("5 Monedas");
		milhouse.addActionListener(new OyenteBoton(milhouse));
		BotonCreacion flanders = new BotonFlanders("/sprites/flanders/boton.png");
		flanders.setText("10 Monedas");
		flanders.addActionListener(new OyenteBoton(flanders));
		BotonCreacion bolaDeNieve = new BotonMartin("/sprites/martin/boton.png");
		bolaDeNieve.setText("20 Monedas");
		bolaDeNieve.addActionListener(new OyenteBoton(bolaDeNieve));
		BotonCreacion ayudanteDeSanta = new BotonSelma("/sprites/selma/boton.png");
		ayudanteDeSanta.setText("15 Monedas");
		ayudanteDeSanta.addActionListener(new OyenteBoton(ayudanteDeSanta));
		
		

		
		// Agrego al panel de los botones
		
		panelBotones.add(homero);
		panelBotones.add(bart);
		panelBotones.add(lisa);
		panelBotones.add(maggie);
		panelBotones.add(marge);
		panelBotones.add(milhouse);
		panelBotones.add(flanders);
		panelBotones.add(bolaDeNieve);
		panelBotones.add(ayudanteDeSanta);
		
		// fondo del frame pricipal
		fondo = new JLabel();
		fondo.setBounds(0,0, 1200, 700);
		fondo.setIcon(new ImageIcon(this.getClass().getResource("/sprites/fondito.png")));
		getContentPane().add(fondo);

		//Agrego y seteo panel que contiene en mapa en el frame.
		
		
	}
	
	public void setMarket(Market mercado){
		this.mercado = mercado;
		panelMapa.setPerso(this.mercado);
		this.mercado.setPanel(panelMapa);
		monedas.setText("Monedas: "+ mercado.getMonedas());
			
	}
	
	public void actualizarCartel(){
		monedas.setText("Monedas: "+ mercado.getMonedas());
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

	public void modificarMarket(int monedas1){
		monedas.setText("Monedas: "+monedas1);
	}
	
	public void modificarVida(int vida) {
		vidas.setText("Vidas: "+vida);
	}
	
	public void modificarNivel(int nivel1) {
		nivel.setText("Nivel: "+ nivel1);
	}
	
	public void modificarPuntos(int punto) {
		puntos.setText("Puntos: "+ punto);
	}
	
	public void terminarOleada() {
		oleada.setVisible(true);
		oleadaPo.setVisible(true);
	}
	
	public void arrancarOleada() {
		oleada.setVisible(false);
		oleadaPo.setVisible(false);
	}
}

