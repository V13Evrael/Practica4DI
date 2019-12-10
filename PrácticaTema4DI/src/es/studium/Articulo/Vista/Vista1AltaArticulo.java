package es.studium.Articulo.Vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class Vista1AltaArticulo extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFNombreArt;
	private JTextField txtFPrecioArt;
	private JTextField txtFStockArt;
	private JButton btnAltaArtSalir;
	private JButton btnLimpiar;
	private JButton btnAltaArt;

	public Vista1AltaArticulo() {
		setTitle("Alta Art\u00EDculo");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 420, 325);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel pnlNorte = new JPanel();
		contentPane.add(pnlNorte, BorderLayout.NORTH);
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
		contentPane.add(pnlCenter, BorderLayout.CENTER);
		
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
		contentPane.add(pnlSur, BorderLayout.SOUTH);
		pnlSur.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlSur1 = new JPanel();
		pnlSur.add(pnlSur1);
		
		btnAltaArt = new JButton("    Dar de alta    ");
		btnAltaArt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		pnlSur1.add(btnAltaArt);
		
		btnLimpiar = new JButton("Limpiar Campos");
		pnlSur1.add(btnLimpiar);
		
		JPanel pnlSur2 = new JPanel();
		pnlSur.add(pnlSur2, BorderLayout.SOUTH);
		
		btnAltaArtSalir = new JButton("Salir");
		pnlSur2.add(btnAltaArtSalir);
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

	public JButton getBtnAltaArtSalir() {
		return btnAltaArtSalir;
	}

	public JButton getBtnLimpiar() {
		return btnLimpiar;
	}

	public JButton getBtnAltaArt() {
		return btnAltaArt;
	}

}
