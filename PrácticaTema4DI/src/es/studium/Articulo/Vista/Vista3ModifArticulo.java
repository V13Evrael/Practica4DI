package es.studium.Articulo.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Vista3ModifArticulo.
 */
public class Vista3ModifArticulo extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The txt filt nom. */
	private JTextField txtFiltNom;
	
	/** The txt filt ID. */
	private JTextField txtFiltID;
	
	/** The txt filt precio. */
	private JTextField txtFiltPrecio;
	
	/** The txt filt stock. */
	private JTextField txtFiltStock;
	
	/** The txt F nombre art. */
	private JTextField txtFNombreArt;
	
	/** The txt F precio art. */
	private JTextField txtFPrecioArt;
	
	/** The txt F stock art. */
	private JTextField txtFStockArt;
	
	/** The btn filt ID. */
	private JButton btnFiltID;
	
	/** The btn filt nom. */
	private JButton btnFiltNom;
	
	/** The btn reset filt. */
	private JButton btnResetFilt;
	
	/** The btn filt precio. */
	private JButton btnFiltPrecio;
	
	/** The btn filt stock. */
	private JButton btnFiltStock;
	
	/** The btn modif art. */
	private JButton btnModifArt;
	
	/** The btn modif salir. */
	private JButton btnModifSalir;
	
	/** The lst art. */
	private JList<String> lstArt;
	
	/** The btn activ campos. */
	private JButton btnActivCampos;
	
	/** The txt A desc art. */
	private JTextArea txtADescArt;

	/**
	 * Instantiates a new vista 3 modif articulo.
	 */
	public Vista3ModifArticulo() {
		setTitle("Modificaci\u00F3n Art\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlOeste = new JPanel();
		pnlOeste.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pnlOeste, BorderLayout.WEST);
		pnlOeste.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pnlOeste1 = new JPanel();
		pnlOeste.add(pnlOeste1);
		
		lstArt = new JList<String>();
		lstArt.setPreferredSize(new Dimension(220, 100));
		lstArt.setModel(new DefaultListModel<String>());
		
		JScrollPane scrollPane = new JScrollPane(lstArt);
		scrollPane.setBorder(null);
		pnlOeste1.add(scrollPane);
		scrollPane.setAutoscrolls(true);
		
		JPanel pnlOeste2 = new JPanel();
		pnlOeste.add(pnlOeste2);
		pnlOeste2.setLayout(null);
		
		txtFiltID = new JTextField();
		txtFiltID.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltID.setForeground(Color.LIGHT_GRAY);
		txtFiltID.setText("Filtrar por ID");
		txtFiltID.setBounds(7, 6, 134, 20);
		
		pnlOeste2.add(txtFiltID);
		txtFiltID.setColumns(16);
		
		btnFiltID = new JButton("Filtrar");
		btnFiltID.setBounds(145, 5, 80, 23);
		btnFiltID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlOeste2.add(btnFiltID);
		
		txtFiltNom = new JTextField();
		txtFiltNom.setText("Filtrar por nombre");
		txtFiltNom.setForeground(Color.LIGHT_GRAY);
		txtFiltNom.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltNom.setBounds(7, 35, 134, 20);
		pnlOeste2.add(txtFiltNom);
		txtFiltNom.setColumns(10);
		
		btnFiltNom = new JButton("Filtrar");
		btnFiltNom.setBounds(145, 34, 80, 23);
		pnlOeste2.add(btnFiltNom);
		
		btnResetFilt = new JButton("Reiniciar Filtro");
		btnResetFilt.setBounds(42, 120, 128, 23);
		pnlOeste2.add(btnResetFilt);
		
		txtFiltPrecio = new JTextField();
		txtFiltPrecio.setText("Filtrar por precio");
		txtFiltPrecio.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltPrecio.setForeground(Color.LIGHT_GRAY);
		txtFiltPrecio.setBounds(7, 64, 134, 20);
		pnlOeste2.add(txtFiltPrecio);
		txtFiltPrecio.setColumns(10);
		
		btnFiltPrecio = new JButton("Filtrar");
		btnFiltPrecio.setBounds(145, 63, 80, 23);
		pnlOeste2.add(btnFiltPrecio);
		
		txtFiltStock = new JTextField();
		txtFiltStock.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltStock.setForeground(Color.LIGHT_GRAY);
		txtFiltStock.setText("Filtrar por stock");
		txtFiltStock.setBounds(7, 93, 135, 20);
		pnlOeste2.add(txtFiltStock);
		txtFiltStock.setColumns(10);
		
		btnFiltStock = new JButton("Filtrar");
		btnFiltStock.setBounds(145, 92, 80, 23);
		pnlOeste2.add(btnFiltStock);
		
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pnlCentro, BorderLayout.CENTER);
		
		JPanel pnlNorte = new JPanel();
		pnlCentro.add(pnlNorte, BorderLayout.NORTH);
		pnlNorte.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel pnlNombreArt = new JPanel();
		pnlNorte.add(pnlNombreArt);
		
		JLabel lblNombreArt = new JLabel("    Nombre:    ");
		pnlNombreArt.add(lblNombreArt);
		
		txtFNombreArt = new JTextField();
		txtFNombreArt.setEditable(false);
		txtFNombreArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlNombreArt.add(txtFNombreArt);
		txtFNombreArt.setColumns(20);
		
		JPanel pnlPrecioArt = new JPanel();
		pnlNorte.add(pnlPrecioArt);
		
		JLabel lblPrecioArt = new JLabel("     Precio:     ");
		pnlPrecioArt.add(lblPrecioArt);
		
		txtFPrecioArt = new JTextField();
		txtFPrecioArt.setEditable(false);
		txtFPrecioArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlPrecioArt.add(txtFPrecioArt);
		txtFPrecioArt.setColumns(20);
		
		JPanel pnlStockArt = new JPanel();
		pnlNorte.add(pnlStockArt);
		
		JLabel lblStockArt = new JLabel("     Stock:      ");
		pnlStockArt.add(lblStockArt);
		
		txtFStockArt = new JTextField();
		txtFStockArt.setEditable(false);
		txtFStockArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlStockArt.add(txtFStockArt);
		txtFStockArt.setColumns(20);
		
		JPanel pnlCenter = new JPanel();
		pnlCentro.add(pnlCenter, BorderLayout.CENTER);
		
		JPanel pnlDescArt = new JPanel();
		pnlCenter.add(pnlDescArt);
		pnlDescArt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDescArt = new JLabel("Descripci\u00F3n:");
		pnlDescArt.add(lblDescArt);
		
		txtADescArt = new JTextArea();
		txtADescArt.setEditable(false);
		txtADescArt.setBackground(new Color(240, 240, 240, 240));
		txtADescArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtADescArt.setRows(5);
		txtADescArt.setColumns(20);
		pnlDescArt.add(txtADescArt);
		
		JPanel pnlSur = new JPanel();
		pnlCentro.add(pnlSur, BorderLayout.SOUTH);
		pnlSur.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSur1 = new JPanel();
		pnlSur.add(pnlSur1);
		
		btnModifArt = new JButton("Modificar Art\u00EDculo");
		btnModifArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlSur1.add(btnModifArt);
		
		btnActivCampos = new JButton(" Activar Campos ");
		pnlSur1.add(btnActivCampos);
		
		JPanel pnlSur2 = new JPanel();
		pnlSur.add(pnlSur2, BorderLayout.SOUTH);
		
		btnModifSalir = new JButton("Salir");
		pnlSur2.add(btnModifSalir);
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
	 * Gets the lst art.
	 *
	 * @return the lst art
	 */
	public JList<String> getLstArt() {
		return lstArt;
	}

	/**
	 * Gets the btn activ campos.
	 *
	 * @return the btn activ campos
	 */
	public JButton getBtnActivCampos() {
		return btnActivCampos;
	}

	/**
	 * Gets the txt filt nom.
	 *
	 * @return the txt filt nom
	 */
	public JTextField getTxtFiltNom() {
		return txtFiltNom;
	}

	/**
	 * Gets the txt filt ID.
	 *
	 * @return the txt filt ID
	 */
	public JTextField getTxtFiltID() {
		return txtFiltID;
	}

	/**
	 * Gets the txt filt precio.
	 *
	 * @return the txt filt precio
	 */
	public JTextField getTxtFiltPrecio() {
		return txtFiltPrecio;
	}

	/**
	 * Gets the txt filt stock.
	 *
	 * @return the txt filt stock
	 */
	public JTextField getTxtFiltStock() {
		return txtFiltStock;
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
	 * Gets the btn filt ID.
	 *
	 * @return the btn filt ID
	 */
	public JButton getBtnFiltID() {
		return btnFiltID;
	}

	/**
	 * Gets the btn filt nom.
	 *
	 * @return the btn filt nom
	 */
	public JButton getBtnFiltNom() {
		return btnFiltNom;
	}

	/**
	 * Gets the btn reset filt.
	 *
	 * @return the btn reset filt
	 */
	public JButton getBtnResetFilt() {
		return btnResetFilt;
	}

	/**
	 * Gets the btn filt precio.
	 *
	 * @return the btn filt precio
	 */
	public JButton getBtnFiltPrecio() {
		return btnFiltPrecio;
	}

	/**
	 * Gets the btn filt stock.
	 *
	 * @return the btn filt stock
	 */
	public JButton getBtnFiltStock() {
		return btnFiltStock;
	}

	/**
	 * Gets the btn modif art.
	 *
	 * @return the btn modif art
	 */
	public JButton getBtnModifArt() {
		return btnModifArt;
	}

	/**
	 * Gets the btn modif salir.
	 *
	 * @return the btn modif salir
	 */
	public JButton getBtnModifSalir() {
		return btnModifSalir;
	}
}