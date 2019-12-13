package es.studium.Articulo.Controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import es.studium.Articulo.Vista.Vista2BajaArticulo;
import es.studium.Modelo.UtilidadesDB;

public class Controlador2BajaArticulo implements ActionListener, ListSelectionListener, MouseListener {

	Vista2BajaArticulo v2BajArt;
	boolean errorMsg = false;
	boolean seguroMsg = false;
	boolean otraBajaMsg = false;

	public Controlador2BajaArticulo() {

		v2BajArt = new Vista2BajaArticulo();
		v2BajArt.setVisible(true);

		v2BajArt.getLstArt().setModel(new DefaultListModel<String>());

		String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos;";
		try {

			UtilidadesDB.complexFillJList(sentencia, (DefaultListModel<String>) v2BajArt.getLstArt().getModel());
		} catch (Exception e) {

		}

		v2BajArt.getBtnBajaArt().addActionListener(this);
		v2BajArt.getBtnBajaArtSalir().addActionListener(this);
		v2BajArt.getLstArt().addListSelectionListener(this);
		v2BajArt.getBtnFiltID().addActionListener(this);
		v2BajArt.getBtnFiltNom().addActionListener(this);
		v2BajArt.getBtnResetFilt().addActionListener(this);
		
		v2BajArt.getTxtFiltID().addMouseListener(this);
		v2BajArt.getTxtFiltNom().addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Cuando pulsamos el bot�n de baja
		if (e.getSource().equals(v2BajArt.getBtnBajaArt())) {

			if (v2BajArt.getTblDatoArtBaj().getValueAt(0, 0).equals("")) {
				JOptionPane.showMessageDialog(v2BajArt,
						"Ning�n elemento seleccionado. Elija uno, marque la casilla de seguridad y vuelva a intentarlo.",
						"Informaci�n", JOptionPane.INFORMATION_MESSAGE);
			}

			else if (v2BajArt.getChBoxSeguro().isSelected()) {

				String[] opciones = { "S�", "No" };
				int seguro = JOptionPane.showOptionDialog(v2BajArt,
						"�Est� seguro/a de que desea dar de baja el art�culo \"NombreArt�culo1\"?", "Confirmaci�n",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, null);
				if (seguro == 0) {

					String sentencia = "DELETE FROM di4db.articulos WHERE (idArticulo = '"
							+ v2BajArt.getTblDatoArtBaj().getValueAt(0, 0) + "');";

					try {

						UtilidadesDB.executeIDA(sentencia, UtilidadesDB.connectDataBase());
						v2BajArt.dispose();
						int repite = JOptionPane.showOptionDialog(v2BajArt,
								"La baja se realiz� satisfactoriamente.\n�Desea realizar otra baja?", "Baja realizada",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);

						if (repite == 0) {
							new Controlador2BajaArticulo();
						}
					} catch (Exception exc) {

						JOptionPane.showMessageDialog(v2BajArt,
								"ERROR: La baja no se pudo realizar.\nRevise los datos y vuelva a intentarlo.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {
				JOptionPane.showMessageDialog(v2BajArt,
						"Marque la casilla correspondiente si est� seguro de que desea dar de baja el art�culo seleccionado",
						"Seguridad", JOptionPane.INFORMATION_MESSAGE);
			}
		}

		// Cuando pulsamos el bot�n de salir
		if (e.getSource().equals(v2BajArt.getBtnBajaArtSalir())) {

			v2BajArt.dispose();
		}

		//Cuando filtramos por ID
		if (e.getSource().equals(v2BajArt.getBtnFiltID())) {
			if (!v2BajArt.getTxtFiltID().getText().equals("Filtrar por ID")) {
				String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos "
						+ "WHERE idArticulo='" + v2BajArt.getTxtFiltID().getText() + "';";
				try {

					((DefaultListModel<String>) v2BajArt.getLstArt().getModel()).clear();
					UtilidadesDB.complexFillJList(sentencia,
							(DefaultListModel<String>) v2BajArt.getLstArt().getModel());
				} catch (Exception exc) {

				}
			}
		}
		
		//Cuando filtramos por Nombre
		if (e.getSource().equals(v2BajArt.getBtnFiltNom())) {
			if (!v2BajArt.getTxtFiltNom().getText().equals("Filtrar por Nombre")) {
				String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos "
						+ "WHERE nombreArticulo LIKE '%" + v2BajArt.getTxtFiltNom().getText() + "%';";
				try {

					((DefaultListModel<String>) v2BajArt.getLstArt().getModel()).clear();
					UtilidadesDB.complexFillJList(sentencia,
							(DefaultListModel<String>) v2BajArt.getLstArt().getModel());
				} catch (Exception exc) {

				}
			}
		}
		
		if (e.getSource().equals(v2BajArt.getBtnResetFilt())) {
			
			String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos;";
			try {
				
				((DefaultListModel<String>) v2BajArt.getLstArt().getModel()).clear();
				UtilidadesDB.complexFillJList(sentencia, (DefaultListModel<String>) v2BajArt.getLstArt().getModel());
				
				v2BajArt.getTxtFiltID().setFont(new Font("Tahoma", Font.ITALIC, 11));
				v2BajArt.getTxtFiltID().setForeground(Color.LIGHT_GRAY);
				v2BajArt.getTxtFiltID().setText("Filtrar por ID");
				
				v2BajArt.getTxtFiltNom().setFont(new Font("Tahoma", Font.ITALIC, 11));
				v2BajArt.getTxtFiltNom().setForeground(Color.LIGHT_GRAY);
				v2BajArt.getTxtFiltNom().setText("Filtrar por Nombre");
				
			} catch (Exception exc) {

			}
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		String id = v2BajArt.getLstArt().getSelectedValue().split(" - ")[0];
		String sentencia = UtilidadesDB.generateSelect(
				"idArticulo, nombreArticulo, precioArticulo, stockArticulo, descripcionArticulo", "articulos",
				"idArticulo = '" + id + "'");

		((DefaultTableModel) v2BajArt.getTblDatoArtBaj().getModel()).removeRow(0);
		UtilidadesDB.complexfillJTable(sentencia, 5, (DefaultTableModel) v2BajArt.getTblDatoArtBaj().getModel());

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource().equals(v2BajArt.getTxtFiltID())) {
			
			v2BajArt.getTxtFiltID().setText("");
			v2BajArt.getTxtFiltID().setFont(new Font(null));
			v2BajArt.getTxtFiltID().setForeground(Color.BLACK);
		}
		
		if (e.getSource().equals(v2BajArt.getTxtFiltNom())) {
			
			v2BajArt.getTxtFiltNom().setText("");
			v2BajArt.getTxtFiltNom().setFont(new Font(null));
			v2BajArt.getTxtFiltNom().setForeground(Color.BLACK);
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
