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

/**
 * La clase Vista4ConsulArticulo.
 * <p>
 * Esta clase que hereda de {@link JFrame} es la Vista que muestra la ventana de consulta de artículos.
 * Mediante el controlador, se le otorgan las funcionalidades para que sus
 * componentes accedan al resto de elementos del programa.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Vista4ConsulArticulo extends JFrame {

	/** Esta constante autogenerada es usada internamente.*/
	private static final long serialVersionUID = 1L;
	
	/** El {@link JPanel} que contiene los demás elementos.*/
	private JPanel contentPane;
	
	/** La {@link JTable} que se rellenará con los Artículos */
	private JTable table;
	
	/** El {@link JButton} usado para salir de la esta vista*/
	private JButton btnSalir;

	/**
	 * Instancia un objeto Vista4ConsulArticulo.
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
		
		JPanel pnlBotonSalir = new JPanel();
		contentPane.add(pnlBotonSalir, BorderLayout.SOUTH);
		
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

}
