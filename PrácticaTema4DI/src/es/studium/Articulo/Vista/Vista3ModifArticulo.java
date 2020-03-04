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

/**
 * La clase Vista3ModifArticulo.
 * <p>
 * Esta clase que hereda de {@link JFrame} es la Vista que muestra la ventana de modificación de artículos.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Vista3ModifArticulo extends JFrame {

	/** Esta constante autogenerada es usada internamente.*/
	private static final long serialVersionUID = 1L;
	
	/** El {@link JPanel} que contiene los demás elementos.*/
	private JPanel contentPane;
	
	/** El {@link JTextField} usado para introducir el nombre del artículo como filtro de búsqueda.*/
	private JTextField txtFiltNom;
	
	/** El {@link JTextField} usado para introducir el ID del artículo como filtro de búsqueda.*/
	private JTextField txtFiltID;
	
	/** El {@link JTextField} usado para introducir el precio del artículo como filtro de búsqueda.*/
	private JTextField txtFiltPrecio;
	
	/** El {@link JTextField} usado para introducir el stock del artículo como filtro de búsqueda.*/
	private JTextField txtFiltStock;
	
	/** El {@link JTextField} usado para introducir el nuevo nombre del artículo */
	private JTextField txtFNombreArt;
	
	/** El {@link JTextField} usado para introducir el nuevo precio del artículo */
	private JTextField txtFPrecioArt;
	
	/** El {@link JTextField} usado para introducir el nuevo stock del artículo */
	private JTextField txtFStockArt;
	
	/** El {@link JButton} usado para aplicar el filtro por ID.*/
	private JButton btnFiltID;
	
	/** El {@link JButton} usado para aplicar el filtro por nombre.*/
	private JButton btnFiltNom;
	
	/** El {@link JButton} usado para resetear el filtro*/
	private JButton btnResetFilt;
	
	/** El {@link JButton} usado para aplicar el filtro por precio.*/
	private JButton btnFiltPrecio;
	
	/** El {@link JButton} usado para aplicar el filtro por stock.*/
	private JButton btnFiltStock;
	
	/** El {@link JButton} usado para modificar el elemento seleccionado.*/
	private JButton btnModifArt;
	
	/** El {@link JButton} usado para salir de la esta vista.*/
	private JButton btnModifSalir;
	
	/** El {@link JList} donde se muestran los Artículos.*/
	private JList<String> lstArt;
	
	/** El {@link JButton} usado para activar/Desactivar los campos.*/
	private JButton btnActivCampos;
	
	/** El {@link JTextField} usado para introducir la descripción detalla del artículo */
	private JTextArea txtADescArt;

	/**
	 * Instancia un objeto Vista3ModifArticulo.
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
	 * Este método devuelve el {@link #txtADescArt}
	 *
	 * @return el {@link JTextArea} txtADescArt
	 */
	public JTextArea getTxtADescArt() {
		return txtADescArt;
	}

	/**
	 * Este método devuelve el {@link #lstArt}
	 *
	 * @return el {@link JList} lstArt
	 */
	public JList<String> getLstArt() {
		return lstArt;
	}

	/**
	 * Este método devuelve el {@link #btnActivCampos}
	 *
	 * @return el {@link JButton} btnActivCampos
	 */
	public JButton getBtnActivCampos() {
		return btnActivCampos;
	}

	/**
	 * Este método devuelve el {@link #txtFiltNom}
	 *
	 * @return el {@link JTextField} txtFiltNom
	 */
	public JTextField getTxtFiltNom() {
		return txtFiltNom;
	}

	/**
	 * Este método devuelve el {@link #txtFiltID}
	 *
	 * @return el {@link JTextField} txtFiltID
	 */
	public JTextField getTxtFiltID() {
		return txtFiltID;
	}

	/**
	 * Este método devuelve el {@link #txtFiltPrecio}
	 *
	 * @return el {@link JTextField} txtFiltPrecio
	 */
	public JTextField getTxtFiltPrecio() {
		return txtFiltPrecio;
	}

	/**
	 * Este método devuelve el {@link #txtFiltStock}
	 *
	 * @return el {@link JTextField} txtFiltStock
	 */
	public JTextField getTxtFiltStock() {
		return txtFiltStock;
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
	 * Este método devuelve el {@link #btnFiltID}
	 *
	 * @return el {@link JButton} btnFiltID
	 */
	public JButton getBtnFiltID() {
		return btnFiltID;
	}

	/**
	 * Este método devuelve el {@link #btnFiltNom}
	 *
	 * @return el {@link JButton} btnFiltNom
	 */
	public JButton getBtnFiltNom() {
		return btnFiltNom;
	}

	/**
	 * Este método devuelve el {@link #btnResetFilt}
	 *
	 * @return el {@link JButton} btnResetFilt
	 */
	public JButton getBtnResetFilt() {
		return btnResetFilt;
	}

	/**
	 * Este método devuelve el {@link #btnFiltPrecio}
	 *
	 * @return el {@link JButton} btnFiltPrecio
	 */
	public JButton getBtnFiltPrecio() {
		return btnFiltPrecio;
	}

	/**
	 * Este método devuelve el {@link #btnFiltStock}
	 *
	 * @return el {@link JButton} btnFiltStock
	 */
	public JButton getBtnFiltStock() {
		return btnFiltStock;
	}

	/**
	 * Este método devuelve el {@link #btnModifArt}
	 *
	 * @return el {@link JButton} btnModifArt
	 */
	public JButton getBtnModifArt() {
		return btnModifArt;
	}

	/**
	 * Este método devuelve el {@link #btnModifSalir}
	 *
	 * @return el {@link JButton} btnModifSalir
	 */
	public JButton getBtnModifSalir() {
		return btnModifSalir;
	}
}