package es.studium.Articulo.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

/**
 * La clase Vista2BajaArticulo.
 * <p>
 * Esta clase que hereda de {@link JFrame} es la Vista que muestra la ventana de baja de artículos.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Vista2BajaArticulo extends JFrame {

	/** Esta constante autogenerada es usada internamente.*/
	private static final long serialVersionUID = 1L;
	
	/** El {@link JPanel} que contiene los demás elementos.*/
	private JPanel contentPane;
	
	/** El {@link JTextField} usado para introducir el ID del artículo como filtro de búsqueda.*/
	private JTextField txtFiltID;
	
	/** El {@link JTextField} usado para introducir el nombre del artículo como filtro de búsqueda.*/
	private JTextField txtFiltNom;
	
	/** La {@link JTable} usada para mostrar los datos del artículo seleccionado.*/
	private JTable tblDatoArtBaj;
	
	/** El {@link JButton} usado para salir de la esta vista.*/
	private JButton btnBajaArtSalir;
	
	/** El {@link JButton} usado para dar de baja el elemento seleccionado.*/
	private JButton btnBajaArt;
	
	/** El {@link JButton} usado para aplicar el filtro por ID.*/
	private JButton btnFiltID;
	
	/** El {@link JButton} usado para aplicar el filtro por nombre.*/
	private JButton btnFiltNom;
	
	/** El {@link JButton} usado para resetear el filtro*/
	private JButton btnResetFilt;
	
	/** El {@link JList} donde se muestran los Artículos.*/
	private JList<String> lstArt;
	
	/** El {@link JCheckBox} usado como mecanismo de seguridad para la baja.*/
	private JCheckBox chBoxSeguro;

	/**
	 * Instancia un objeto Vista2BajaArticulo.
	 */
	public Vista2BajaArticulo() {
		setTitle("Baja Art\u00EDculo");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 800, 270);
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
		lstArt.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstArt.setPreferredSize(new Dimension(220, 100));
		
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
		txtFiltID.setBounds(6, 6, 134, 20);
		
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
		txtFiltNom.setBounds(6, 37, 134, 20);
		pnlOeste2.add(txtFiltNom);
		txtFiltNom.setColumns(10);
		
		btnFiltNom = new JButton("Filtrar");
		btnFiltNom.setBounds(145, 36, 80, 23);
		pnlOeste2.add(btnFiltNom);
		
		btnResetFilt = new JButton("Reiniciar Filtro");
		btnResetFilt.setBounds(42, 84, 128, 23);
		pnlOeste2.add(btnResetFilt);
				
		JPanel pnlEste = new JPanel();
		pnlEste.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(0, 5, 0, 0)));
		contentPane.add(pnlEste, BorderLayout.CENTER);
		pnlEste.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlEste1 = new JPanel();
		pnlEste.add(pnlEste1);
		pnlEste1.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlEste1Norte = new JPanel();
		pnlEste1.add(pnlEste1Norte, BorderLayout.NORTH);
		pnlEste1Norte.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblDatos = new JLabel("Datos del Art\u00EDculo:");
		pnlEste1Norte.add(lblDatos);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		pnlEste1Norte.add(panel);
		
		tblDatoArtBaj = new JTable();
		tblDatoArtBaj.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", ""},
			},
			new String[] {
				"ID", "Nombre", "Precio", "Stock", "Descripci\u00F3n"
			}
		));
		
		tblDatoArtBaj.getColumnModel().getColumn(0).setPreferredWidth(49);
		tblDatoArtBaj.getColumnModel().getColumn(1).setPreferredWidth(98);
		tblDatoArtBaj.getColumnModel().getColumn(2).setPreferredWidth(90);
		tblDatoArtBaj.getColumnModel().getColumn(3).setPreferredWidth(87);
		tblDatoArtBaj.getColumnModel().getColumn(4).setPreferredWidth(114);
		panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane_1 = new JScrollPane(tblDatoArtBaj);
		scrollPane_1.setBorder(null);
		panel.add(scrollPane_1);
		scrollPane_1.setPreferredSize(new Dimension(400, 39));
		
		JPanel panel_1 = new JPanel();
		pnlEste1Norte.add(panel_1);
		
		chBoxSeguro = new JCheckBox("Marque si est\u00E1 seguro de que desea dar de baja el art\u00EDculo");
		panel_1.add(chBoxSeguro);
		
		JPanel pnlEste1Center = new JPanel();
		pnlEste1.add(pnlEste1Center, BorderLayout.CENTER);
		pnlEste1Center.setLayout(null);
		
		btnBajaArt = new JButton("Dar de baja");
		btnBajaArt.setBounds(200, 34, 117, 23);
		pnlEste1Center.add(btnBajaArt);
		
		btnBajaArtSalir = new JButton("Salir");
		btnBajaArtSalir.setBounds(200, 75, 117, 23);
		pnlEste1Center.add(btnBajaArtSalir);
		
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
	 * Este método devuelve el {@link #txtFiltID}
	 *
	 * @return el {@link JTextField} txtFiltID
	 */
	public JTextField getTxtFiltID() {
		return txtFiltID;
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
	 * Este método devuelve el {@link #tblDatoArtBaj}
	 *
	 * @return el {@link JTable} tblDatoArtBaj
	 */
	public JTable getTblDatoArtBaj() {
		return tblDatoArtBaj;
	}

	/**
	 * Este método devuelve el {@link #btnBajaArtSalir}
	 *
	 * @return el {@link JButton} btnBajaArtSalir
	 */
	public JButton getBtnBajaArtSalir() {
		return btnBajaArtSalir;
	}

	/**
	 * Este método devuelve el {@link #btnBajaArt}
	 *
	 * @return el {@link JButton} btnBajaArt
	 */
	public JButton getBtnBajaArt() {
		return btnBajaArt;
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
	 * Este método devuelve el {@link #chBoxSeguro}
	 *
	 * @return el {@link JCheckBox} chBoxSeguro
	 */
	public JCheckBox getChBoxSeguro() {
		return chBoxSeguro;
	}
}
