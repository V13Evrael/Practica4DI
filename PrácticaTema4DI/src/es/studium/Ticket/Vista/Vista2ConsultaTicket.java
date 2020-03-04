package es.studium.Ticket.Vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

/**
 * La clase Vista2ConsultaTicket.
 * <p>
 * Esta clase que hereda de {@link JFrame} es la Vista que muestra una consulta de los Tickets.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Vista2ConsultaTicket extends JFrame {

	/** Esta constante autogenerada es usada internamente. */
	private static final long serialVersionUID = 1L;
	
	/** El {@link JPanel} que contiene los demás elementos. */
	private JPanel contentPane;
	
	/** La {@link JTable} que se rellenará con los Tickets */
	private JTable table;
		
	/** El {@link JButton} usado para salir de la esta vista*/
	private JButton btnSalir;
	
	/** El {@link JButton} usado para acceder a los detalles del Ticket, abriendo un objeto de la clase {@link Vista2ConsultaTicketDial}*/
	private JButton btnMostrarTicket;

	/**
	 * Instancia un objeto Vista2ConsultaTicket.
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
		
		JPanel pnlBotonSalir = new JPanel();
		contentPane.add(pnlBotonSalir, BorderLayout.SOUTH);
		
		btnMostrarTicket = new JButton("Mostrar Ticket");
		pnlBotonSalir.add(btnMostrarTicket);
		
		btnSalir = new JButton("Salir al men\u00FA");
		pnlBotonSalir.add(btnSalir);
	}

	/**
	 * Este método devuelve el {@link #table}
	 *
	 * @return el {@link JTable} table
	 */
	public JTable getTable() {
		return table;
	}

	/**
	 * Este método devuelve el {@link #btnSalir}
	 *
	 * @return el {@link JButton} btnSalir
	 */
	public JButton getBtnSalir() {
		return btnSalir;
	}

	/**
	 * Este método devuelve el {@link #btnMostrarTicket}
	 *
	 * @return el {@link JButton} btnMostrarTicket
	 */
	public JButton getBtnMostrar() {
		return btnMostrarTicket;
	}
}
