package es.studium.Ticket.Vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

// TODO: Auto-generated Javadoc
/**
 * The Class Vista3InformeTicket.
 */
public class Vista3InformeTicket extends JFrame {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The content pane. */
	private JPanel contentPane;
	
	/** The txt fecha min. */
	private JTextField txtFechaMin;
	
	/** The txt fecha max. */
	private JTextField txtFechaMax;
	
	/** The btn crear informe. */
	private JButton btnCrearInforme;

	/**
	 * Instantiates a new vista 3 informe ticket.
	 */
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

	/**
	 * Gets the txt fecha min.
	 *
	 * @return the txt fecha min
	 */
	public JTextField getTxtFechaMin() {
		return txtFechaMin;
	}

	/**
	 * Gets the txt fecha max.
	 *
	 * @return the txt fecha max
	 */
	public JTextField getTxtFechaMax() {
		return txtFechaMax;
	}

	/**
	 * Gets the btn crear informe.
	 *
	 * @return the btn crear informe
	 */
	public JButton getBtnCrearInforme() {
		return btnCrearInforme;
	}

}
