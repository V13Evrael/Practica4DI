package es.studium.Main;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * La clase VistaPrincipal.
 * <p>
 * Esta clase que hereda de {@link JFrame} es la Vista inicial del programa.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 */
public class VistaPrincipal extends JFrame {

	/** Esta constante autogenerada es usada internamente. */
	private static final long serialVersionUID = 1L;

	/** El {@link JPanel} que contiene los demás elementos. */
	private JPanel contentPane;

	/** La {@link JMenuBar barra de menú} que contendrá los distintos menús. */
	private JMenuBar menuBar;

	/** El {@link JMenuItem ítem de menú} que se usará para abrir la ventana de Alta de Artículos. */
	private JMenuItem mnItAltaArt;

	/** El {@link JMenuItem ítem de menú} que se usará para abrir la ventana de Modificación de Artículos. */
	private JMenuItem mnItModArt;

	/** El {@link JMenuItem ítem de menú} que se usará para abrir la ventana de Baja de Artículos. */
	private JMenuItem mnItBajaArt;

	/** El {@link JMenuItem ítem de menú} que se usará para abrir la ventana de Consulta de Artículos. */
	private JMenuItem mnItConArt;

	/** El {@link JMenuItem ítem de menú} que se usará para generar un Informe de los Artículos. */
	private JMenuItem mnItInfArt;

	/** El {@link JMenuItem ítem de menú} que se usará para abrir la ventana de Alta de Tickets. */
	private JMenuItem mnItAltaTick;

	/** El {@link JMenuItem ítem de menú} que se usará para abrir la ventana de Consulta de Tickets. */
	private JMenuItem mnItConTick;

	/** El {@link JMenuItem ítem de menú} que se usará para abrir la ventana de selección de fecha para generar un Informe de Tickets. */
	private JMenuItem mnItInfTick;

	/**
	 * Instancia un objeto VistaPrincipal.
	 */
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

		mnItInfArt = new JMenuItem("Generar Informe de Artículos");
		mnArticulos.add(mnItInfArt);

		JMenu mnTickets = new JMenu("Tickets");
		menuBar.add(mnTickets);

		mnItAltaTick = new JMenuItem("Alta Ticket");
		mnTickets.add(mnItAltaTick);

		mnItConTick = new JMenuItem("Consulta Ticket");
		mnTickets.add(mnItConTick);

		mnItInfTick = new JMenuItem("Generar Informe de Tickets");
		mnTickets.add(mnItInfTick);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

	/**
	 * Este método devuelve el {@link #mnItAltaArt}
	 *
	 * @return el {@link JMenuItem} mnItAltaArt
	 */
	public JMenuItem getMnItAltaArt() {
		return mnItAltaArt;
	}

	/**
	 * Este método devuelve el {@link #mnItModArt}
	 *
	 * @return el {@link JMenuItem} mnItModArt
	 */
	public JMenuItem getMnItModArt() {
		return mnItModArt;
	}

	/**
	 * Este método devuelve el {@link #mnItBajaArt}
	 *
	 * @return el {@link JMenuItem} mnItBajaArt
	 */
	public JMenuItem getMnItBajaArt() {
		return mnItBajaArt;
	}

	/**
	 * Este método devuelve el {@link #mnItConArt}
	 *
	 * @return el {@link JMenuItem} mnItConArt
	 */
	public JMenuItem getMnItConArt() {
		return mnItConArt;
	}

	/**
	 * Este método devuelve el {@link #mnItAltaTick}
	 *
	 * @return el {@link JMenuItem} mnItAltaTick
	 */
	public JMenuItem getMnItAltaTick() {
		return mnItAltaTick;
	}

	/**
	 * Este método devuelve el {@link #mnItConTick}
	 *
	 * @return el {@link JMenuItem} mnItConTick
	 */
	public JMenuItem getMnItConTick() {
		return mnItConTick;
	}

	/**
	 * Este método devuelve el {@link #mnItInfArt}
	 *
	 * @return el {@link JMenuItem} mnItInfArt
	 */
	public JMenuItem getMnItInfArt() {
		return mnItInfArt;
	}

	/**
	 * Este método devuelve el {@link #mnItInfTick}
	 *
	 * @return el {@link JMenuItem} mnItInfTick
	 */
	public JMenuItem getMnItInfTick() {
		return mnItInfTick;
	}
}
