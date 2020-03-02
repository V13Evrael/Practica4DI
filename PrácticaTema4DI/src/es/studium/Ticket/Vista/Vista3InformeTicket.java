package es.studium.Ticket.Vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Vista3InformeTicket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFechaMin;
	private JTextField txtFechaMax;
	private JButton btnCrearInforme;

	public Vista3InformeTicket() {
		setTitle("Indica el rango");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 290, 140);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblFechaMin = new JLabel("Indique Fecha M\u00EDnima  ");
		contentPane.add(lblFechaMin);
		
		txtFechaMin = new JTextField();
		contentPane.add(txtFechaMin);
		txtFechaMin.setColumns(10);
		
		JLabel lblFechaMax = new JLabel("Indique Fecha M\u00E1xima");
		contentPane.add(lblFechaMax);
		
		txtFechaMax = new JTextField();
		contentPane.add(txtFechaMax);
		txtFechaMax.setColumns(10);
		
		btnCrearInforme = new JButton("Crear Informe");
		contentPane.add(btnCrearInforme);
	}

	public JTextField getTxtFechaMin() {
		return txtFechaMin;
	}

	public JTextField getTxtFechaMax() {
		return txtFechaMax;
	}

	public JButton getBtnCrearInforme() {
		return btnCrearInforme;
	}

}
