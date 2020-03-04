package es.studium.Ticket.Vista;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

/**
 * La clase Vista2ConsultaTicket.
 * <p>
 * Esta clase que hereda de {@link JFrame} es la Vista usada para la selección del intervalo de fecha para generar un Informe de los Tickets.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Vista3InformeTicket extends JFrame {

	/** Esta constante autogenerada es usada internamente. */
	private static final long serialVersionUID = 1L;
	
	/** El {@link JPanel} que contiene los demás elementos. */
	private JPanel contentPane;
	
	/** El {@link JTextField} usado para introducir la fecha mínima de los Tickets del Informe.*/
	private JTextField txtFechaMin;
	
	/** El {@link JTextField} usado para introducir la fecha máxima de los Tickets del Informe.*/
	private JTextField txtFechaMax;
	
	/** El {@link JButton} usado para crear el Informe de Tickets*/
	private JButton btnCrearInforme;

	/**
	 * Instancia un objeto Vista3InformeTicket.
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
	 * Este método devuelve el {@link #txtFechaMin}
	 *
	 * @return el {@link JTextField} txtFechaMin
	 */
	public JTextField getTxtFechaMin() {
		return txtFechaMin;
	}

	/**
	 * Este método devuelve el {@link #txtFechaMax}
	 *
	 * @return el {@link JTextField} txtFechaMax
	 */
	public JTextField getTxtFechaMax() {
		return txtFechaMax;
	}

	/**
	 * Este método devuelve el {@link #btnCrearInforme}
	 *
	 * @return el {@link JButton} btnCrearInforme
	 */
	public JButton getBtnCrearInforme() {
		return btnCrearInforme;
	}

}
