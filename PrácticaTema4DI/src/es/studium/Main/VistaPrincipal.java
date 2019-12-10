package es.studium.Main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenuItem mnItAltaArt;
	private JMenuItem mnItModArt;
	private JMenuItem mnItBajaArt;
	private JMenuItem mnItConArt;
	private JMenuItem mnItAltaTick;
	private JMenuItem mnItConTick;
	private JMenuItem mnItSalir;

	public VistaPrincipal() {
		setTitle("Men\u00FA Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArticulos = new JMenu("Art\u00EDculos");
		menuBar.add(mnArticulos);
		
		mnItAltaArt = new JMenuItem("Alta Art\u00EDculo");
		mnArticulos.add(mnItAltaArt);
		
		mnItModArt = new JMenuItem("Modificaci\u00F3n Art\u00EDculo");
		mnArticulos.add(mnItModArt);
		
		mnItBajaArt = new JMenuItem("Baja Art\u00EDculo");
		mnArticulos.add(mnItBajaArt);
		
		mnItConArt = new JMenuItem("Consulta Art\u00EDculos");
		mnArticulos.add(mnItConArt);
		
		JMenu mnTickets = new JMenu("Tickets");
		menuBar.add(mnTickets);
		
		mnItAltaTick = new JMenuItem("Alta Ticket");
		mnTickets.add(mnItAltaTick);
		
		mnItConTick = new JMenuItem("Consulta Ticket");
		mnTickets.add(mnItConTick);
		
		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);
		
		mnItSalir = new JMenuItem("Salir");
		mnOpciones.add(mnItSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	public JMenuItem getMnItAltaArt() {
		return mnItAltaArt;
	}

	public JMenuItem getMnItModArt() {
		return mnItModArt;
	}

	public JMenuItem getMnItBajaArt() {
		return mnItBajaArt;
	}

	public JMenuItem getMnItConArt() {
		return mnItConArt;
	}

	public JMenuItem getMnItAltaTick() {
		return mnItAltaTick;
	}

	public JMenuItem getMnItConTick() {
		return mnItConTick;
	}

	public JMenuItem getMnItSalir() {
		return mnItSalir;
	}
}
