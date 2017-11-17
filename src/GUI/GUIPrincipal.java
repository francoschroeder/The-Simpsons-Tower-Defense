package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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
import Juego.HiloEnemigos;

import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;

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
		
		vidas = new JTextField();
		vidas.setBackground(Color.YELLOW);
		vidas.setText("Vidas: ");
		vidas.setForeground(Color.BLACK);
		vidas.setColumns(10);
		vidas.setBounds(1211, 722, 157, 50);
		getContentPane().add(vidas);
		
		nivel = new JTextField();
		nivel.setBackground(Color.YELLOW);
		nivel.setForeground(Color.BLACK);
		nivel.setColumns(10);
		nivel.setBounds(1211, 660, 157, 50);
		getContentPane().add(nivel);
		
		puntos = new JTextField();
		puntos.setBackground(Color.YELLOW);
		puntos.setForeground(Color.BLACK);
		puntos.setBounds(1211, 598, 157, 50);
		getContentPane().add(puntos);
		puntos.setColumns(10);
		
		monedas = new JTextField();
		monedas.setBackground(Color.YELLOW);
		getContentPane().add(monedas);
		monedas.setBounds(1211, 536, 157, 50);
		monedas.setColumns(10);
		monedas.setEditable(false);
		
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
		
		BotonCreacion homero = new BotonHomero("/sprites/homero/CaraHomeroBoton.jpg");
		homero.addActionListener(new OyenteBoton(homero));
		BotonCreacion bart = new BotonBart("/sprites/bart/boton.png");
		bart.addActionListener(new OyenteBoton(bart));
		BotonCreacion lisa = new BotonLisa("/sprites/lisa/boton.png");
		lisa.addActionListener(new OyenteBoton(lisa));
		BotonCreacion maggie = new BotonMaggie("/sprites/maggie/boton.png");
		maggie.addActionListener(new OyenteBoton(maggie));
		BotonCreacion marge = new BotonMarge("/sprites/marge/boton.png");
		marge.addActionListener(new OyenteBoton(marge));
		BotonCreacion milhouse = new BotonMilhouse("/sprites/milhouse/boton.png");
		milhouse.addActionListener(new OyenteBoton(milhouse));
		BotonCreacion flanders = new BotonFlanders("/sprites/flanders/boton.png");
		flanders.addActionListener(new OyenteBoton(flanders));
		BotonCreacion bolaDeNieve = new BotonMartin("/sprites/martin/boton.png");
		bolaDeNieve.addActionListener(new OyenteBoton(bolaDeNieve));
		BotonCreacion ayudanteDeSanta = new BotonSelma("/sprites/selma/boton.png");
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
	
	public void pasarNivel(HiloEnemigos e, int a) {
		try{ e.wait();}
		catch (Exception o) {}
		modificarNivel(a);
		JFrame pantalla = new JFrame();
		JButton pasarNivel = new JButton("Pasar de Nivel\n");
		pasarNivel.addActionListener(new OyenteGanador(e));
		JTextField txtGanaste = new JTextField();
		txtGanaste.setFont(new Font("Marker Felt", Font.PLAIN, 74));
		txtGanaste.setText("Ganaste!!!");
		txtGanaste.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(pantalla.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(137)
							.addComponent(pasarNivel, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(78)
							.addComponent(txtGanaste, GroupLayout.PREFERRED_SIZE, 304, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(35)
					.addComponent(txtGanaste, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
					.addGap(90)
					.addComponent(pasarNivel, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		pantalla.getContentPane().setLayout(groupLayout);
		
	}
	
	private class OyenteGanador implements ActionListener{
		HiloEnemigos a;
		public OyenteGanador(HiloEnemigos a){
			this.a = a;
		}
		public void actionPerformed(ActionEvent e){
			a.start();
			
		}
	}
	








}

