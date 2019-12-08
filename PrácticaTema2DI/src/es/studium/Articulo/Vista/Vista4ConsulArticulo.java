package es.studium.Articulo.Vista;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class Vista4ConsulArticulo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JPanel pnlBotonSalir;
	private JButton btnSalir;

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
				{"1", "NombreArt1", "PrecioArt1", "StockArt1", "Descripci\u00F3nArt1"},
				{"2", "NombreArt2", "PrecioArt2", "StockArt2", "Descripci\u00F3nArt2"},
				{"3", "NombreArt3", "PrecioArt3", "StockArt3", "Descripci\u00F3nArt3"},
				{"4", "NombreArt4", "PrecioArt4", "StockArt4", "Descripci\u00F3nArt4"},
				{"5", "NombreArt5", "PrecioArt5", "StockArt5", "Descripci\u00F3nArt5"},
				{"6", "NombreArt6", "PrecioArt6", "StockArt6", "Descripci\u00F3nArt6"},
				{"7", "NombreArt7", "PrecioArt7", "StockArt7", "Descripci\u00F3nArt7"},
				{"8", "NombreArt8", "PrecioArt8", "StockArt8", "Descripci\u00F3nArt8"},
				{"9", "NombreArt9", "PrecioArt9", "StockArt9", "Descripci\u00F3nArt9"},
				{"10", "NombreArt10", "PrecioArt10", "StockArt10", "Descripci\u00F3nArt10"},
				{"11", "NombreArt11", "PrecioArt11", "StockArt11", "Descripci\u00F3nArt11"},
				{"12", "NombreArt12", "PrecioArt12", "StockArt12", "Descripci\u00F3nArt12"},
				{"13", "NombreArt13", "PrecioArt13", "StockArt13", "Descripci\u00F3nArt13"},
				{"14", "NombreArt14", "PrecioArt14", "StockArt14", "Descripci\u00F3nArt14"},
				{"15", "NombreArt15", "PrecioArt15", "StockArt15", "Descripci\u00F3nArt15"},
				{"16", "NombreArt16", "PrecioArt16", "StockArt16", "Descripci\u00F3nArt16"},
				{"17", "NombreArt17", "PrecioArt17", "StockArt17", "Descripci\u00F3nArt17"},
				{"18", "NombreArt18", "PrecioArt18", "StockArt18", "Descripci\u00F3nArt18"},
				{"19", "NombreArt19", "PrecioArt19", "StockArt19", "Descripci\u00F3nArt19"},
				{"20", "NombreArt20", "PrecioArt20", "StockArt20", "Descripci\u00F3nArt20"},
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
	
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		pnlBotonSalir = new JPanel();
		contentPane.add(pnlBotonSalir, BorderLayout.SOUTH);
		
		btnSalir = new JButton("Salir al men\u00FA");
		pnlBotonSalir.add(btnSalir);
	}

	public JTable getTable() {
		return table;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

}
