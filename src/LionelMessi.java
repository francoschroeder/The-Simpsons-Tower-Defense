import java.awt.Point;
import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;

import GUI.GUIPrincipal;
import GUI.PanelMapa;
import GUI.Botones.BotonCreacion;
import GUI.Botones.Market;
import Juego.Enemigo;
import Juego.HiloAtaque;
import Juego.HiloDisparo;
import Juego.HiloEnemigos;
import Juego.Juego;
import Personajes.Barney;
import Personajes.MrBurns;
import Personajes.Nelson;
import Personajes.PerrosBurns;
import Personajes.Skinner;
import Personajes.Smithers;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LionelMessi extends JFrame {
	protected JLabel fondo;
	private static HiloEnemigos h;
	private static HiloDisparo disparo;
	private static HiloAtaque a;
	private static Stack<Enemigo> enemigosPorSalir;
	private static GUIPrincipal gui;
	private static Juego j;
	
		
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LionelMessi frame = new LionelMessi();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public LionelMessi() {
		// frama
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(400, 220, 665, 500);
		
		//panel del fondo
		JPanel panelPrincipal = new JPanel();
		
		
		// boton inicio
		JButton jugar = new JButton("jugar\n\n");
		jugar.addActionListener(new OyenteBoton());
		jugar.setFont(new Font("Marker Felt", Font.BOLD, 25));
		
		//fondo del panel
		fondo = new JLabel ();
		fondo.setBounds(0, 0, 650, 400);
		fondo.setIcon(new ImageIcon(this.getClass().getResource("/sprites/fondoJuego.png")));
		GroupLayout gl_panelPrincipal = new GroupLayout(panelPrincipal);
		gl_panelPrincipal.setHorizontalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addGroup(gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
						.addComponent(fondo)
						.addGroup(gl_panelPrincipal.createSequentialGroup()
							.addGap(170)
							.addComponent(jugar, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(8, Short.MAX_VALUE))
		);
		gl_panelPrincipal.setVerticalGroup(
			gl_panelPrincipal.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPrincipal.createSequentialGroup()
					.addComponent(fondo)
					.addGap(18)
					.addComponent(jugar, GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
					.addGap(14))
		);
		panelPrincipal.setLayout(gl_panelPrincipal);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(6)
					.addComponent(panelPrincipal, GroupLayout.PREFERRED_SIZE, 658, GroupLayout.PREFERRED_SIZE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panelPrincipal, GroupLayout.PREFERRED_SIZE, 469, GroupLayout.PREFERRED_SIZE)
		);
		getContentPane().setLayout(groupLayout);
	
	}
	
	private class OyenteBoton implements ActionListener{
		
		public OyenteBoton(){}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			jugar();
		}
	}
		
	
	
	
		
	public void jugar() {		
		enemigosPorSalir = new Stack<Enemigo>();
		gui = new GUIPrincipal();
		j = new Juego(gui);
		crearEnemigosPorSalir();
		Market market = new Market(j);
		disparo = new HiloDisparo(gui.getPanelMapa()); 
		h = new HiloEnemigos(j, disparo, enemigosPorSalir);
		a = new HiloAtaque(j,disparo);
		
		gui.setJuego(j);
		gui.setMarket(market);
		gui.setVisible(true);
		h.start();
		disparo.start();
		a.start();
		
		/*while (!j.perdio()) {
			if (!h.hayEnemigosPorSalir()) {
				h.detener();
				ganarNivel();
			}
		}*/
		
	}
	
	private static void crearEnemigosPorSalir() {
		
		LinkedList<Enemigo> enemigos = new LinkedList<Enemigo>();
		Random r = new Random();
		int cantPorSalir = r.nextInt(6) +15;
		
		Enemigo s1 = new Skinner();
		Enemigo s2 = new PerrosBurns();
		Enemigo s3 = new MrBurns();
		Enemigo s4 = new Smithers();
		Enemigo s5 = new Barney();
		Enemigo s6 = new Nelson();
		
		enemigos.add(s1);
		enemigos.add(s2);
		enemigos.add(s3);
		enemigos.add(s4);
		enemigos.add(s5);
		enemigos.add(s6);
		
		for(int i=0; i< cantPorSalir; i++) {
			Enemigo e = enemigos.get(r.nextInt(enemigos.size())).clone();
			Point pos = new Point(r.nextInt(6),0);
			e.setPosicion(pos);
			enemigosPorSalir.push(e);
		}
	}
	
	private static void actualizarNivel() {
		j.pasarDeNivel();
		enemigosPorSalir = new Stack<Enemigo>();
		crearEnemigosPorSalir();
		h = new HiloEnemigos(j, disparo, enemigosPorSalir);
	}



	/**
	 * 
	 */
 	public void ganarNivel() {
 		JFrame GanadorNivel = new JFrame();
 		JTextField txtGanaste;
 		GanadorNivel.getContentPane().setBackground(Color.YELLOW);
		JButton btnNewButton = new JButton("Siguiente nivel\n");
		btnNewButton.addActionListener(new OyenteBoton1());
		txtGanaste = new JTextField();
		txtGanaste.setBackground(Color.YELLOW);
		txtGanaste.setFont(new Font("Marker Felt", Font.PLAIN, 29));
		txtGanaste.setText("GANASTE!");
		txtGanaste.setColumns(10);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(122, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE)
					.addGap(162))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(186)
					.addComponent(txtGanaste, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(187, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(59)
					.addComponent(txtGanaste, GroupLayout.PREFERRED_SIZE, 85, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addGap(34))
		);
		getContentPane().setLayout(groupLayout);
	
 	
		
				
			}
 	private class OyenteBoton1 implements ActionListener{
		 
		public OyenteBoton1(){
		
		}
		public void actionPerformed(ActionEvent e){
			actualizarNivel();
			}
 		}
 	}
