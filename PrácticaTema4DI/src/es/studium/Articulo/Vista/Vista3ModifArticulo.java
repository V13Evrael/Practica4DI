package es.studium.Articulo.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Vista3ModifArticulo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFiltNom;
	private JTextField txtFiltID;
	private JTextField txtFiltPrecio;
	private JTextField txtFiltrarPorStock;
	private JTextField txtFNombreArt;
	private JTextField txtFPrecioArt;
	private JTextField txtFStockArt;
	private JButton btnFiltID;
	private JButton btnFiltNom;
	private JButton btnResetFilt;
	private JButton btnFiltPrecio;
	private JButton btnFiltStock;
	private JButton btnModifArt;
	private JButton btnModifSalir;

	public Vista3ModifArticulo() {
		setTitle("Modificaci\u00F3n Art\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 580, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlOeste = new JPanel();
		pnlOeste.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pnlOeste, BorderLayout.WEST);
		pnlOeste.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel pnlOeste1 = new JPanel();
		pnlOeste.add(pnlOeste1);
		
		JList<String> lstArt = new JList<String>();
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
		pnlOeste.add(pnlOeste2);
		pnlOeste2.setLayout(null);
		
		txtFiltID = new JTextField();
		txtFiltID.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltID.setForeground(Color.LIGHT_GRAY);
		txtFiltID.setText("Filtrar por ID");
		txtFiltID.setBounds(7, 6, 134, 20);
		
		pnlOeste2.add(txtFiltID);
		txtFiltID.setColumns(16);
		
		btnFiltID = new JButton("Filtrar");
		btnFiltID.setBounds(145, 5, 80, 23);
		btnFiltID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlOeste2.add(btnFiltID);
		
		txtFiltNom = new JTextField();
		txtFiltNom.setText("Filtrar por nombre");
		txtFiltNom.setForeground(Color.LIGHT_GRAY);
		txtFiltNom.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltNom.setBounds(7, 35, 134, 20);
		pnlOeste2.add(txtFiltNom);
		txtFiltNom.setColumns(10);
		
		btnFiltNom = new JButton("Filtrar");
		btnFiltNom.setBounds(145, 34, 80, 23);
		pnlOeste2.add(btnFiltNom);
		
		btnResetFilt = new JButton("Reiniciar Filtro");
		btnResetFilt.setBounds(42, 120, 128, 23);
		pnlOeste2.add(btnResetFilt);
		
		txtFiltPrecio = new JTextField();
		txtFiltPrecio.setText("Filtrar por precio");
		txtFiltPrecio.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltPrecio.setForeground(Color.LIGHT_GRAY);
		txtFiltPrecio.setBounds(7, 64, 134, 20);
		pnlOeste2.add(txtFiltPrecio);
		txtFiltPrecio.setColumns(10);
		
		btnFiltPrecio = new JButton("Filtrar");
		btnFiltPrecio.setBounds(145, 63, 80, 23);
		pnlOeste2.add(btnFiltPrecio);
		
		txtFiltrarPorStock = new JTextField();
		txtFiltrarPorStock.setFont(new Font("Tahoma", Font.ITALIC, 11));
		txtFiltrarPorStock.setForeground(Color.LIGHT_GRAY);
		txtFiltrarPorStock.setText("Filtrar por stock");
		txtFiltrarPorStock.setBounds(7, 93, 135, 20);
		pnlOeste2.add(txtFiltrarPorStock);
		txtFiltrarPorStock.setColumns(10);
		
		btnFiltStock = new JButton("Filtrar");
		btnFiltStock.setBounds(145, 92, 80, 23);
		pnlOeste2.add(btnFiltStock);
		
		JPanel pnlCentro = new JPanel();
		pnlCentro.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(pnlCentro, BorderLayout.CENTER);
		
		JPanel pnlNorte = new JPanel();
		pnlCentro.add(pnlNorte, BorderLayout.NORTH);
		pnlNorte.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel pnlNombreArt = new JPanel();
		pnlNorte.add(pnlNombreArt);
		
		JLabel lblNombreArt = new JLabel("    Nombre:    ");
		pnlNombreArt.add(lblNombreArt);
		
		txtFNombreArt = new JTextField();
		txtFNombreArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlNombreArt.add(txtFNombreArt);
		txtFNombreArt.setColumns(20);
		
		JPanel pnlPrecioArt = new JPanel();
		pnlNorte.add(pnlPrecioArt);
		
		JLabel lblPrecioArt = new JLabel("     Precio:     ");
		pnlPrecioArt.add(lblPrecioArt);
		
		txtFPrecioArt = new JTextField();
		txtFPrecioArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlPrecioArt.add(txtFPrecioArt);
		txtFPrecioArt.setColumns(20);
		
		JPanel pnlStockArt = new JPanel();
		pnlNorte.add(pnlStockArt);
		
		JLabel lblStockArt = new JLabel("     Stock:      ");
		pnlStockArt.add(lblStockArt);
		
		txtFStockArt = new JTextField();
		txtFStockArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		pnlStockArt.add(txtFStockArt);
		txtFStockArt.setColumns(20);
		
		JPanel pnlCenter = new JPanel();
		pnlCentro.add(pnlCenter, BorderLayout.CENTER);
		
		JPanel pnlDescArt = new JPanel();
		pnlCenter.add(pnlDescArt);
		pnlDescArt.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblDescArt = new JLabel("Descripci\u00F3n:");
		pnlDescArt.add(lblDescArt);
		
		JTextArea txtADescArt = new JTextArea();
		txtADescArt.setBorder(new LineBorder(Color.LIGHT_GRAY));
		txtADescArt.setRows(5);
		txtADescArt.setColumns(20);
		pnlDescArt.add(txtADescArt);
		
		JPanel pnlSur = new JPanel();
		pnlCentro.add(pnlSur, BorderLayout.SOUTH);
		pnlSur.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSur1 = new JPanel();
		pnlSur.add(pnlSur1);
		
		btnModifArt = new JButton("Modificar Art\u00EDculo");
		btnModifArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlSur1.add(btnModifArt);
		
		JButton btnActivCampos = new JButton(" Activar Campos ");
		pnlSur1.add(btnActivCampos);
		
		JPanel pnlSur2 = new JPanel();
		pnlSur.add(pnlSur2, BorderLayout.SOUTH);
		
		btnModifSalir = new JButton("Salir");
		pnlSur2.add(btnModifSalir);
	}

	public JTextField getTxtFiltNom() {
		return txtFiltNom;
	}

	public JTextField getTxtFiltID() {
		return txtFiltID;
	}

	public JTextField getTxtFiltPrecio() {
		return txtFiltPrecio;
	}

	public JTextField getTxtFiltrarPorStock() {
		return txtFiltrarPorStock;
	}

	public JTextField getTxtFNombreArt() {
		return txtFNombreArt;
	}

	public JTextField getTxtFPrecioArt() {
		return txtFPrecioArt;
	}

	public JTextField getTxtFStockArt() {
		return txtFStockArt;
	}

	public JButton getBtnFiltID() {
		return btnFiltID;
	}

	public JButton getBtnFiltNom() {
		return btnFiltNom;
	}

	public JButton getBtnResetFilt() {
		return btnResetFilt;
	}

	public JButton getBtnFiltPrecio() {
		return btnFiltPrecio;
	}

	public JButton getBtnFiltStock() {
		return btnFiltStock;
	}

	public JButton getBtnModifArt() {
		return btnModifArt;
	}

	public JButton getBtnModifSalir() {
		return btnModifSalir;
	}
}
