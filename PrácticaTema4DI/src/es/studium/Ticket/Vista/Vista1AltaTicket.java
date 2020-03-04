package es.studium.Ticket.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import es.studium.Modelo.UtilidadesDB;

/**
 * La clase Vista1AltaTicket.
 * <p>
 * Esta clase que hereda de {@link JFrame} es la Vista que muestra la ventana de altas de Tickets.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Vista1AltaTicket extends JFrame {

	/** Esta constante autogenerada es usada internamente. */
	private static final long serialVersionUID = 1L;
	
	/** El {@link JPanel} que contiene los demás elementos. */
	private JPanel contentPane;
	
	/** La {@link JTable} que se rellenará con los Artículos ya añadidos con su datos.*/
	private JTable tblDatoArt;
	
	/** El {@link JTextField} usado para introducir el nombre del Artículo como Filtro.*/
	private JTextField txtFiltNom;
	
	/** El {@link JTextField} usado para introducir el ID del Artículo como Filtro.*/
	private JTextField txtFiltID;
	
	/** El {@link JTextField} usado para introducir la cantidad de Artículo para añadir al Ticket.*/
	private JTextField txtFCant;
	
	/** El {@link JTextField} usado para introducir el precio Total del Ticket.*/
	private JTextField txtFTotal;
	
	/** El {@link JList} donde se muestran los Artículos para añadir.*/
	private JList<String> lstArt;
	
	/** El {@link JButton} usado para aplicar el filtro por ID.*/
	private JButton btnFiltID;
	
	/** El {@link JButton} usado para aplicar el filtro por nombre.*/
	private JButton btnFiltNom;
	
	/** El {@link JButton} usado para añadir el producto seleccionado al Ticket.*/
	private JButton btnAgregarACompra;
	
	/** El {@link JButton} usado para resetear los filtros por ID.*/
	private JButton btnResetFilt;
	
	/** El {@link JButton} usado para dar de alta el Ticket. */
	private JButton btnFinalizarCompra;
	
	/** El {@link JButton} usado para eliminar un artículo de la {@link #tblDatoArt}.*/
	private JButton btnEliminar;

	/**
	 * Instancia un objeto Vista1AltaTicket.
	 */
	public Vista1AltaTicket() {
		setTitle("Alta Ticket");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlOeste = new JPanel();
		pnlOeste.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pnlOeste, BorderLayout.WEST);
		pnlOeste.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlOeste1 = new JPanel();
		pnlOeste.add(pnlOeste1, BorderLayout.CENTER);
		
		lstArt = new JList<String>();
		lstArt.setPreferredSize(new Dimension(220, 100));
		lstArt.setModel(new DefaultListModel<String>());
		
		JScrollPane scrollPane = new JScrollPane(lstArt);
		scrollPane.setBorder(null);
		pnlOeste1.add(scrollPane);
		scrollPane.setAutoscrolls(true);
		
		JPanel pnlOeste2 = new JPanel();
		pnlOeste.add(pnlOeste2, BorderLayout.SOUTH);
		pnlOeste2.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel pnlFiltID = new JPanel();
		pnlOeste2.add(pnlFiltID);
		
		txtFiltID = new JTextField();
		pnlFiltID.add(txtFiltID);
		txtFiltID.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltID.setForeground(Color.LIGHT_GRAY);
		txtFiltID.setText("Filtrar por ID");
		txtFiltID.setColumns(16);
		
		btnFiltID = new JButton("Filtrar");
		pnlFiltID.add(btnFiltID);
		btnFiltID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel pnlFiltNom = new JPanel();
		pnlOeste2.add(pnlFiltNom);
		
		txtFiltNom = new JTextField();
		pnlFiltNom.add(txtFiltNom);
		txtFiltNom.setText("Filtrar por nombre");
		txtFiltNom.setForeground(Color.LIGHT_GRAY);
		txtFiltNom.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltNom.setColumns(16);
		
		btnFiltNom = new JButton("Filtrar");
		pnlFiltNom.add(btnFiltNom);
		
		JPanel pnlFiltCant = new JPanel();
		pnlOeste2.add(pnlFiltCant);
		
		JLabel lblCant = new JLabel("Cantidad: ");
		pnlFiltCant.add(lblCant);
		
		txtFCant = new JTextField();
		pnlFiltCant.add(txtFCant);
		txtFCant.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		pnlOeste2.add(panel_1);
		
		btnAgregarACompra = new JButton("Agregar a Compra");
		panel_1.add(btnAgregarACompra);
		
		btnResetFilt = new JButton("Reiniciar Filtro");
		panel_1.add(btnResetFilt);
				
		JPanel pnlEste = new JPanel();
		pnlEste.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(0, 5, 0, 0)));
		contentPane.add(pnlEste, BorderLayout.CENTER);
		pnlEste.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlEste1 = new JPanel();
		pnlEste.add(pnlEste1);
		pnlEste1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDatos = new JLabel("<HTML>Fecha: " + UtilidadesDB.formatoDateSQL(UtilidadesDB.takeDate()) + "<br><br></HTML>");
		pnlEste1.add(lblDatos, BorderLayout.NORTH);
		lblDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel = new JPanel();
		pnlEste1.add(panel, BorderLayout.CENTER);
		
		tblDatoArt = new JTable();
		tblDatoArt.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDatoArt.setModel(new DefaultTableModel(
			null,
			new String[] {
				"ID", "Art\u00EDculo", "Cantidad", "Precio/Unidad"
			}
		));
		tblDatoArt.getColumnModel().getColumn(0).setPreferredWidth(55);
		tblDatoArt.getColumnModel().getColumn(1).setPreferredWidth(90);
		tblDatoArt.getColumnModel().getColumn(2).setPreferredWidth(87);
		tblDatoArt.getColumnModel().getColumn(3).setPreferredWidth(100);
		panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane_1 = new JScrollPane(tblDatoArt);
		panel.add(scrollPane_1, BorderLayout.CENTER);
		scrollPane_1.setBorder(null);
		scrollPane_1.setPreferredSize(new Dimension(400, 39));
		
		JPanel panel_2 = new JPanel();
		pnlEste1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.EAST);
		
		JLabel lblTotal = new JLabel("Total Compra: ");
		panel_3.add(lblTotal);
		
		txtFTotal = new JTextField();
		panel_3.add(txtFTotal);
		txtFTotal.setColumns(16);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		
		btnEliminar = new JButton("Eliminar de la lista");
		panel_4.add(btnEliminar);
		
		btnFinalizarCompra = new JButton("Finalizar Compra");
		panel_4.add(btnFinalizarCompra);
	}

	/**
	 * Este método devuelve el {@link #table}
	 *
	 * @return el {@link JTable} tblDatoArt
	 */
	public JTable getTblDatoArtBaj() {
		return tblDatoArt;
	}

	/**
	 * Este método devuelve el {@link #btnEliminar}
	 *
	 * @return el {@link JButton} btnEliminar
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
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
	 * Este método devuelve el {@link #txtFCant}
	 *
	 * @return el {@link JTextField} txtFCant
	 */
	public JTextField getTxtFCant() {
		return txtFCant;
	}

	/**
	 * Este método devuelve el {@link #txtFTotal}
	 *
	 * @return el {@link JTextField} txtFTotal
	 */
	public JTextField getTxtFTotal() {
		return txtFTotal;
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
	 * Este método devuelve el {@link #btnAgregarACompra}
	 *
	 * @return el {@link JButton} btnAgregarACompra
	 */
	public JButton getBtnAgregarACompra() {
		return btnAgregarACompra;
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
	 * Este método devuelve el {@link #btnFinalizarCompra}
	 *
	 * @return el {@link JButton} btnFinalizarCompra
	 */
	public JButton getBtnFinalizarCompra() {
		return btnFinalizarCompra;
	}
}
