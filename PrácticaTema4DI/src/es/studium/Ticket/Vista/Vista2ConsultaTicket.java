package es.studium.Ticket.Vista;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Vista2ConsultaTicket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JPanel pnlBotonSalir;
	private JButton btnSalir;
	private JButton btnMostrarTicket;

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

	public JTable getTable() {
		return table;
	}

	public JPanel getPnlBotonSalir() {
		return pnlBotonSalir;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JButton getBtnMostrar() {
		return btnMostrarTicket;
	}
}
