package es.studium.Articulo.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 * La clase Vista1AltaArticulo.
 * <p>
 * Esta clase que hereda de {@link JFrame} es la Vista que muestra la ventana de altas de artículos.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 */
public class Vista1AltaArticulo extends JFrame {

	/** Esta constante autogenerada es usada internamente. */
	private static final long serialVersionUID = 1L;
	
	/** El {@link JPanel} que contiene los demás elementos. */
	private JPanel contentPane;
	
	/** El {@link JTextField} usado para introducir el nombre del artículo */
	private JTextField txtFNombreArt;
	
	/** El {@link JTextField} usado para introducir el precio del artículo */
	private JTextField txtFPrecioArt;
	
	/** El {@link JTextField} usado para introducir el stock del artículo */
	private JTextField txtFStockArt;
	
	/** El {@link JButton} usado para salir de la esta vista*/
	private JButton btnAltaArtSalir;
	
	/** El {@link JButton} usado para limpar los campos de esta vista*/
	private JButton btnLimpiar;
	
	/** El {@link JButton} usado para dar de alta el artículo */
	private JButton btnAltaArt;
	
	/** El {@link JTextField} usado para introducir la descripción detalla del artículo */
	private JTextArea txtADescArt;

	/**
	 * Instancia un objeto Vista1AltaArticulo.
	 */
	public Vista1AltaArticulo() {
		setTitle("Alta Art\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlNorte = new JPanel();
		contentPane.add(pnlNorte, BorderLayout.NORTH);
		pnlNorte.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel pnlNombreArt = new JPanel();
		pnlNorte.add(pnlNombreArt);
		
		JLabel lblNombreArt = new JLabel("    Nombre:    ");
		pnlNombreArt.add(lblNombreArt);
		
		txtFNombreArt = new JTextField();
		txtFNombreArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlNombreArt.add(txtFNombreArt);
		txtFNombreArt.setColumns(20);
		
		JPanel pnlPrecioArt = new JPanel();
		pnlNorte.add(pnlPrecioArt);
		
		JLabel lblPrecioArt = new JLabel("     Precio:     ");
		pnlPrecioArt.add(lblPrecioArt);
		
		txtFPrecioArt = new JTextField();
		txtFPrecioArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlPrecioArt.add(txtFPrecioArt);
		txtFPrecioArt.setColumns(20);
		
		JPanel pnlStockArt = new JPanel();
		pnlNorte.add(pnlStockArt);
		
		JLabel lblStockArt = new JLabel("     Stock:      ");
		pnlStockArt.add(lblStockArt);
		
		txtFStockArt = new JTextField();
		txtFStockArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlStockArt.add(txtFStockArt);
		txtFStockArt.setColumns(20);
		
		JPanel pnlCenter = new JPanel();
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
		JPanel pnlDescArt = new JPanel();
		pnlCenter.add(pnlDescArt);
		pnlDescArt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDescArt = new JLabel("Descripci\u00F3n:");
		pnlDescArt.add(lblDescArt);
		
		txtADescArt = new JTextArea();
		txtADescArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtADescArt.setRows(5);
		txtADescArt.setColumns(20);
		pnlDescArt.add(txtADescArt);
		
		JPanel pnlSur = new JPanel();
		contentPane.add(pnlSur, BorderLayout.SOUTH);
		pnlSur.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSur1 = new JPanel();
		pnlSur.add(pnlSur1);
		
		btnAltaArt = new JButton("    Dar de alta    ");
		btnAltaArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlSur1.add(btnAltaArt);
		
		btnLimpiar = new JButton("Limpiar Campos");
		pnlSur1.add(btnLimpiar);
		
		JPanel pnlSur2 = new JPanel();
		pnlSur.add(pnlSur2, BorderLayout.SOUTH);
		
		btnAltaArtSalir = new JButton("Salir");
		pnlSur2.add(btnAltaArtSalir);
	}

	/**
	 * Este método devuelve el {@link #txtADescArt}
	 *
	 * @return el {@link JTextArea} txtADescArt
	 */
	public JTextArea getTxtADescArt() {
		return txtADescArt;
	}

	/**
	 * Este método devuelve el {@link #txtFNombreArt}
	 *
	 * @return el {@link JTextField} txtFNombreArt
	 */
	public JTextField getTxtFNombreArt() {
		return txtFNombreArt;
	}

	/**
	 * Este método devuelve el {@link #txtFPrecioArt}
	 *
	 * @return el {@link JTextField} txtFPrecioArt
	 */
	public JTextField getTxtFPrecioArt() {
		return txtFPrecioArt;
	}

	/**
	 * Este método devuelve el {@link #txtFStockArt}
	 *
	 * @return el {@link JTextField} txtFStockArt
	 */
	public JTextField getTxtFStockArt() {
		return txtFStockArt;
	}

	/**
	 * Este método devuelve el {@link #btnAltaArtSalir}
	 *
	 * @return el {@link JButton} btnAltaArtSalir
	 */
	public JButton getBtnAltaArtSalir() {
		return btnAltaArtSalir;
	}

	/**
	 * Este método devuelve el {@link #btnLimpiar}
	 *
	 * @return el {@link JButton} btnLimpiar
	 */
	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	/**
	 * Este método devuelve el {@link #btnAltaArt}
	 *
	 * @return el {@link JButton} btnAltaArt
	 */
	public JButton getBtnAltaArt() {
		return btnAltaArt;
	}

}
