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
				{"1", "ImporteTicket1", "FechaTicket1"},
				{"2", "ImporteTicket2", "FechaTicket2"},
				{"3", "ImporteTicket3", "FechaTicket3"},
				{"4", "ImporteTicket4", "FechaTicket4"},
				{"5", "ImporteTicket5", "FechaTicket5"},
				{"6", "ImporteTicket6", "FechaTicket6"},
				{"7", "ImporteTicket7", "FechaTicket7"},
				{"8", "ImporteTicket8", "FechaTicket8"},
				{"9", "ImporteTicket9", "FechaTicket9"},
				{"10", "ImporteTicket10", "FechaTicket10"},
				{"11", "ImporteTicket11", "FechaTicket11"},
				{"12", "ImporteTicket12", "FechaTicket12"},
				{"13", "ImporteTicket13", "FechaTicket13"},
				{"14", "ImporteTicket14", "FechaTicket14"},
				{"15", "ImporteTicket15", "FechaTicket15"},
				{"16", "ImporteTicket16", "FechaTicket16"},
				{"17", "ImporteTicket17", "FechaTicket17"},
				{"18", "ImporteTicket18", "FechaTicket18"},
				{"19", "ImporteTicket19", "FechaTicket19"},
				{"20", "ImporteTicket20", "FechaTicket20"},
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


}
