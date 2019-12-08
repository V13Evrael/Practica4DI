package es.studium.Ticket.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class Vista1AltaTicket extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblDatoArtBaj;
	private JTextField txtFiltNom;
	private JTextField txtFiltID;
	private JTextField txtFCant;
	private JTextField txtFTotal;
	private JList<String> lstArt;
	private JButton btnFiltID;
	private JButton btnFiltrar;
	private JButton btnAgregarACompra;
	private JButton btnResetFilt;
	private JButton btnFinalizarCompra;

	public Vista1AltaTicket() {
		setTitle("Alta TIcket");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 653, 324);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlOeste = new JPanel();
		pnlOeste.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pnlOeste, BorderLayout.WEST);
		pnlOeste.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlOeste1 = new JPanel();
		pnlOeste.add(pnlOeste1, BorderLayout.CENTER);
		
		lstArt = new JList<String>();
		lstArt.setPreferredSize(new Dimension(220, 100));
		lstArt.setModel(new DefaultListModel<String>() {

			private static final long serialVersionUID = 1L;
			
			String[] values = new String[] {"Art\u00EDculo de Prueba 1", "Art\u00EDculo de Prueba 2", "Art\u00EDculo de Prueba 3", "Art\u00EDculo de Prueba 4"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		JScrollPane scrollPane = new JScrollPane(lstArt);
		scrollPane.setBorder(null);
		pnlOeste1.add(scrollPane);
		scrollPane.setAutoscrolls(true);
		
		JPanel pnlOeste2 = new JPanel();
		pnlOeste.add(pnlOeste2, BorderLayout.SOUTH);
		pnlOeste2.setLayout(new GridLayout(4, 1, 0, 0));
		
		JPanel pnlFiltID = new JPanel();
		pnlOeste2.add(pnlFiltID);
		
		txtFiltID = new JTextField();
		pnlFiltID.add(txtFiltID);
		txtFiltID.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltID.setForeground(Color.LIGHT_GRAY);
		txtFiltID.setText("Filtrar por ID");
		txtFiltID.setColumns(16);
		
		btnFiltID = new JButton("Filtrar");
		pnlFiltID.add(btnFiltID);
		btnFiltID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JPanel pnlFiltNom = new JPanel();
		pnlOeste2.add(pnlFiltNom);
		
		txtFiltNom = new JTextField();
		pnlFiltNom.add(txtFiltNom);
		txtFiltNom.setText("Filtrar por nombre");
		txtFiltNom.setForeground(Color.LIGHT_GRAY);
		txtFiltNom.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltNom.setColumns(16);
		
		btnFiltrar = new JButton("Filtrar");
		pnlFiltNom.add(btnFiltrar);
		
		JPanel pnlFiltCant = new JPanel();
		pnlOeste2.add(pnlFiltCant);
		
		JLabel lblCant = new JLabel("Cantidad: ");
		pnlFiltCant.add(lblCant);
		
		txtFCant = new JTextField();
		pnlFiltCant.add(txtFCant);
		txtFCant.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		pnlOeste2.add(panel_1);
		
		btnAgregarACompra = new JButton("Agregar a Compra");
		panel_1.add(btnAgregarACompra);
		
		btnResetFilt = new JButton("Reiniciar Filtro");
		panel_1.add(btnResetFilt);
				
		JPanel pnlEste = new JPanel();
		pnlEste.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0)), new EmptyBorder(0, 5, 0, 0)));
		contentPane.add(pnlEste, BorderLayout.CENTER);
		pnlEste.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlEste1 = new JPanel();
		pnlEste.add(pnlEste1);
		pnlEste1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblDatos = new JLabel("<HTML>Fecha: _____________<br><br></HTML>");
		pnlEste1.add(lblDatos, BorderLayout.NORTH);
		lblDatos.setHorizontalAlignment(SwingConstants.RIGHT);
		
		JPanel panel = new JPanel();
		pnlEste1.add(panel, BorderLayout.CENTER);
		
		tblDatoArtBaj = new JTable();
		tblDatoArtBaj.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		tblDatoArtBaj.setModel(new DefaultTableModel(
			new Object[][] {
				{"1", "Art\u00EDculo 1", "2", "60\u20AC"},
				{"2", "Art\u00EDculo 2", "1", "10\u20AC"},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ID", "Art\u00EDculo", "Cantidad", "Precio/Unidad"
			}
		));
		tblDatoArtBaj.getColumnModel().getColumn(0).setPreferredWidth(55);
		tblDatoArtBaj.getColumnModel().getColumn(1).setPreferredWidth(90);
		tblDatoArtBaj.getColumnModel().getColumn(2).setPreferredWidth(87);
		tblDatoArtBaj.getColumnModel().getColumn(3).setPreferredWidth(100);
		panel.setLayout(new BorderLayout(0, 0));
		JScrollPane scrollPane_1 = new JScrollPane(tblDatoArtBaj);
		panel.add(scrollPane_1, BorderLayout.CENTER);
		scrollPane_1.setBorder(null);
		scrollPane_1.setPreferredSize(new Dimension(400, 39));
		
		JPanel panel_2 = new JPanel();
		pnlEste1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.EAST);
		
		JLabel lblTotal = new JLabel("Total Compra: ");
		panel_3.add(lblTotal);
		
		txtFTotal = new JTextField();
		panel_3.add(txtFTotal);
		txtFTotal.setColumns(16);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		
		btnFinalizarCompra = new JButton("Finalizar Compra");
		panel_4.add(btnFinalizarCompra);
	}

	public JTable getTblDatoArtBaj() {
		return tblDatoArtBaj;
	}

	public JTextField getTxtFiltNom() {
		return txtFiltNom;
	}

	public JTextField getTxtFiltID() {
		return txtFiltID;
	}

	public JTextField getTxtFCant() {
		return txtFCant;
	}

	public JTextField getTxtFTotal() {
		return txtFTotal;
	}

	public JList<String> getLstArt() {
		return lstArt;
	}

	public JButton getBtnFiltID() {
		return btnFiltID;
	}

	public JButton getBtnFiltrar() {
		return btnFiltrar;
	}

	public JButton getBtnAgregarACompra() {
		return btnAgregarACompra;
	}

	public JButton getBtnResetFilt() {
		return btnResetFilt;
	}

	public JButton getBtnFinalizarCompra() {
		return btnFinalizarCompra;
	}
}
