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
 * Esta clase que hereda de {@link JFrame} es la Vista que muestra las altas.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 */
public class Vista1AltaArticulo extends JFrame {

	/** Esta constante autogenerada es usada internamente. */
	private static final long serialVersionUID = 1L;
	
	/** El {@link JPanel} que contiene los demás elementos. */
	private JPanel contentPane;
	
	/**  */
	private JTextField txtFNombreArt;
	
	/** The txt F precio art. */
	private JTextField txtFPrecioArt;
	
	/** The txt F stock art. */
	private JTextField txtFStockArt;
	
	/** The btn alta art salir. */
	private JButton btnAltaArtSalir;
	
	/** The btn limpiar. */
	private JButton btnLimpiar;
	
	/** The btn alta art. */
	private JButton btnAltaArt;
	
	/** The txt A desc art. */
	private JTextArea txtADescArt;

	/**
	 * Instantiates a new vista 1 alta articulo.
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
	 * Gets the txt A desc art.
	 *
	 * @return the txt A desc art
	 */
	public JTextArea getTxtADescArt() {
		return txtADescArt;
	}

	/**
	 * Gets the txt F nombre art.
	 *
	 * @return the txt F nombre art
	 */
	public JTextField getTxtFNombreArt() {
		return txtFNombreArt;
	}

	/**
	 * Gets the txt F precio art.
	 *
	 * @return the txt F precio art
	 */
	public JTextField getTxtFPrecioArt() {
		return txtFPrecioArt;
	}

	/**
	 * Gets the txt F stock art.
	 *
	 * @return the txt F stock art
	 */
	public JTextField getTxtFStockArt() {
		return txtFStockArt;
	}

	/**
	 * Gets the btn alta art salir.
	 *
	 * @return the btn alta art salir
	 */
	public JButton getBtnAltaArtSalir() {
		return btnAltaArtSalir;
	}

	/**
	 * Gets the btn limpiar.
	 *
	 * @return the btn limpiar
	 */
	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	/**
	 * Gets the btn alta art.
	 *
	 * @return the btn alta art
	 */
	public JButton getBtnAltaArt() {
		return btnAltaArt;
	}

}
