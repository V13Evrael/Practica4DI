package es.studium.Articulo.Vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import es.studium.Modelo.UtilidadesDB;

import javax.swing.JButton;

// TODO: Auto-generated Javadoc
/**
 * The Class Vista4ConsulArticulo.
 */
public class Vista4ConsulArticulo extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The table. */
	private JTable table;
	
	/** The pnl boton salir. */
	private JPanel pnlBotonSalir;
	
	/** The btn salir. */
	private JButton btnSalir;

	/**
	 * Instantiates a new vista 4 consul articulo.
	 */
	public Vista4ConsulArticulo() {
		setTitle("Consulta Art\u00EDculos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "Precio", "Stock", "Descripci\u00F3n"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		table.getColumnModel().getColumn(3).setPreferredWidth(93);
		table.getColumnModel().getColumn(4).setPreferredWidth(112);
		JScrollPane scrollPane = new JScrollPane(table);
		
		String sentencia = "SELECT *FROM articulos;";
		UtilidadesDB.complexfillJTable(sentencia, 5, (DefaultTableModel) table.getModel());
	
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		pnlBotonSalir = new JPanel();
		contentPane.add(pnlBotonSalir, BorderLayout.SOUTH);
		
		btnSalir = new JButton("Salir al men\u00FA");
		pnlBotonSalir.add(btnSalir);
	}

	/**
	 * Gets the table.
	 *
	 * @return the table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * Gets the btn salir.
	 *
	 * @return the btn salir
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

}
