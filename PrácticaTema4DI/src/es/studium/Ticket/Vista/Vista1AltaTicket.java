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

// TODO: Auto-generated Javadoc
/**
 * The Class Vista1AltaTicket.
 */
public class Vista1AltaTicket extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The tbl dato art baj. */
	private JTable tblDatoArtBaj;
	
	/** The txt filt nom. */
	private JTextField txtFiltNom;
	
	/** The txt filt ID. */
	private JTextField txtFiltID;
	
	/** The txt F cant. */
	private JTextField txtFCant;
	
	/** The txt F total. */
	private JTextField txtFTotal;
	
	/** The lst art. */
	private JList<String> lstArt;
	
	/** The btn filt ID. */
	private JButton btnFiltID;
	
	/** The btn filt nom. */
	private JButton btnFiltNom;
	
	/** The btn agregar A compra. */
	private JButton btnAgregarACompra;
	
	/** The btn reset filt. */
	private JButton btnResetFilt;
	
	/** The btn finalizar compra. */
	private JButton btnFinalizarCompra;
	
	/** The btn eliminar. */
	private JButton btnEliminar;

	/**
	 * Instantiates a new vista 1 alta ticket.
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
		
		tblDatoArtBaj = new JTable();
		tblDatoArtBaj.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDatoArtBaj.setModel(new DefaultTableModel(
			null,
			new String[] {
				"ID", "Art\u00EDculo", "Cantidad", "Precio/Unidad"
			}
		));
		tblDatoArtBaj.getColumnModel().getColumn(0).setPreferredWidth(55);
		tblDatoArtBaj.getColumnModel().getColumn(1).setPreferredWidth(90);
		tblDatoArtBaj.getColumnModel().getColumn(2).setPreferredWidth(87);
		tblDatoArtBaj.getColumnModel().getColumn(3).setPreferredWidth(100);
		panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane_1 = new JScrollPane(tblDatoArtBaj);
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
	 * Gets the tbl dato art baj.
	 *
	 * @return the tbl dato art baj
	 */
	public JTable getTblDatoArtBaj() {
		return tblDatoArtBaj;
	}

	/**
	 * Gets the btn eliminar.
	 *
	 * @return the btn eliminar
	 */
	public JButton getBtnEliminar() {
		return btnEliminar;
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
	 * Gets the txt F cant.
	 *
	 * @return the txt F cant
	 */
	public JTextField getTxtFCant() {
		return txtFCant;
	}

	/**
	 * Gets the txt F total.
	 *
	 * @return the txt F total
	 */
	public JTextField getTxtFTotal() {
		return txtFTotal;
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
	 * Gets the btn agregar A compra.
	 *
	 * @return the btn agregar A compra
	 */
	public JButton getBtnAgregarACompra() {
		return btnAgregarACompra;
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
	 * Gets the btn finalizar compra.
	 *
	 * @return the btn finalizar compra
	 */
	public JButton getBtnFinalizarCompra() {
		return btnFinalizarCompra;
	}
}
