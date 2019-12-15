package es.studium.Ticket.Vista;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Vista2ConsultaTicketDial extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField textField;
	private JButton btnVolver;

	public Vista2ConsultaTicketDial(String id, String fecha, String total) {
		setBounds(100, 100, 550, 300);
		getContentPane().setLayout(new BorderLayout());
		this.setTitle("Ticket ID: " + id);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblFechan = new JLabel("<HTML>Fecha: " + fecha + " <br><br></HTML>");
		panel.add(lblFechan, BorderLayout.EAST);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Ártículo", "Cantidad", "Precio/Unidad", "Precio Total" }));

		JScrollPane scrollPane = new JScrollPane(table);

		contentPanel.add(scrollPane);

		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		contentPanel.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JLabel lblTotal = new JLabel("Total Compra: ");
		panel_1.add(lblTotal);

		textField = new JTextField();
		textField.setText(total + " €");
		textField.setEditable(false);

		panel_1.add(textField);
		textField.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnVolver = new JButton("Volver");
				btnVolver.setActionCommand("Cancel");
				buttonPane.add(btnVolver);
			}
		}
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	}

	public JButton getBtnVolver() {
		return btnVolver;
	}

	public JTable getTable() {
		return table;
	}

}
