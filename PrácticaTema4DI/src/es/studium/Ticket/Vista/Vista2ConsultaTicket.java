package es.studium.Ticket.Vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

// TODO: Auto-generated Javadoc
/**
 * The Class Vista2ConsultaTicket.
 */
public class Vista2ConsultaTicket extends JFrame {

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
	
	/** The btn mostrar ticket. */
	private JButton btnMostrarTicket;

	/**
	 * Instantiates a new vista 2 consulta ticket.
	 */
	public Vista2ConsultaTicket() {
		setTitle("Consulta Ticket");
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
				"ID Ticket", "Importe", "Fecha"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(85);
		table.getColumnModel().getColumn(2).setPreferredWidth(89);
		JScrollPane scrollPane = new JScrollPane(table);
	
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		pnlBotonSalir = new JPanel();
		contentPane.add(pnlBotonSalir, BorderLayout.SOUTH);
		
		btnMostrarTicket = new JButton("Mostrar Ticket");
		pnlBotonSalir.add(btnMostrarTicket);
		
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
	 * Gets the pnl boton salir.
	 *
	 * @return the pnl boton salir
	 */
	public JPanel getPnlBotonSalir() {
		return pnlBotonSalir;
	}

	/**
	 * Gets the btn salir.
	 *
	 * @return the btn salir
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * Gets the btn mostrar.
	 *
	 * @return the btn mostrar
	 */
	public JButton getBtnMostrar() {
		return btnMostrarTicket;
	}
}
