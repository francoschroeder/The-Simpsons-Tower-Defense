package GUI;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import GUI.Botones.BotonMaggie;
import GUI.Botones.BotonMarge;
import GUI.Botones.BotonMilhouse;
import GUI.Botones.BotonAyudanteSanta;
import GUI.Botones.BotonBart;
import GUI.Botones.BotonBolaNieve;
import GUI.Botones.BotonCreacion;
import GUI.Botones.BotonFlanders;
import GUI.Botones.BotonHomero;
import GUI.Botones.BotonLisa;
import GUI.Botones.Market;


import java.awt.event.ActionListener;

import java.awt.Color;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
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
	private JTextField txtEscudos;
	private JTextField txtLuchadores;
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
		
		//Panel de los botones
		
		panelBotones = new JPanel();
		getContentPane().add(panelBotones);
		panelBotones.setBounds(216, 485, 915, 287);
		
	
		
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
		BotonCreacion bolaDeNieve = new BotonBolaNieve("/sprites/martin/boton.png");
		bolaDeNieve.addActionListener(new OyenteBoton(bolaDeNieve));
		BotonCreacion ayudanteDeSanta = new BotonAyudanteSanta("/sprites/selma/boton.png");
		ayudanteDeSanta.addActionListener(new OyenteBoton(ayudanteDeSanta));
		
		txtEscudos = new JTextField();
		txtEscudos.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtEscudos.setText("Escudos\n");
		txtEscudos.setColumns(10);
		
		txtLuchadores = new JTextField();
		txtLuchadores.setText("Luchadores\n");
		txtLuchadores.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtLuchadores.setColumns(10);
		GroupLayout gl_panelBotones = new GroupLayout(panelBotones);
		gl_panelBotones.setHorizontalGroup(
			gl_panelBotones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panelBotones.createSequentialGroup()
							.addComponent(txtEscudos, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(milhouse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(flanders, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bolaDeNieve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, gl_panelBotones.createSequentialGroup()
							.addComponent(txtLuchadores, GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(homero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(bart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(maggie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.LEADING)
						.addComponent(marge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ayudanteDeSanta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panelBotones.setVerticalGroup(
			gl_panelBotones.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelBotones.createParallelGroup(Alignment.LEADING)
						.addComponent(marge, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(Alignment.TRAILING, gl_panelBotones.createSequentialGroup()
							.addGroup(gl_panelBotones.createParallelGroup(Alignment.LEADING)
								.addComponent(homero, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(bart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lisa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(maggie, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panelBotones.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_panelBotones.createSequentialGroup()
									.addGap(18)
									.addGroup(gl_panelBotones.createParallelGroup(Alignment.TRAILING)
										.addComponent(bolaDeNieve, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(flanders, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(ayudanteDeSanta, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(milhouse, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addGroup(Alignment.TRAILING, gl_panelBotones.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtEscudos, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(50))))))
				.addGroup(gl_panelBotones.createSequentialGroup()
					.addGap(53)
					.addComponent(txtLuchadores, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(204, Short.MAX_VALUE))
		);
		panelBotones.setLayout(gl_panelBotones);
		//Agrego y seteo panel que contiene en mapa en el frame.
		
		ImageIcon img= new ImageIcon(this.getClass().getResource("/sprites/fondo.png")); ;
		panelMapa = new PanelMapa(img.getImage());
		panelMapa.setSize(750, 450);
		getContentPane().add(panelMapa);
		panelMapa.setForeground(Color.WHITE);
		panelMapa.setLocation(381, 23);
		
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
}

