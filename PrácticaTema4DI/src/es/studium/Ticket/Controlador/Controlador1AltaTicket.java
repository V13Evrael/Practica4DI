package es.studium.Ticket.Controlador;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import es.studium.Modelo.UtilidadesDB;
import es.studium.Ticket.Vista.Vista1AltaTicket;

public class Controlador1AltaTicket implements ActionListener, MouseListener {

	Vista1AltaTicket v1AltTic;

	public Controlador1AltaTicket() {

		v1AltTic = new Vista1AltaTicket();
		v1AltTic.setVisible(true);

		String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo, ' - Stock: ', stockArticulo) FROM articulos WHERE stockArticulo>0;";
		try {

			UtilidadesDB.complexFillJList(sentencia, (DefaultListModel<String>) v1AltTic.getLstArt().getModel());
		} catch (Exception e) {

		}

		v1AltTic.getBtnFinalizarCompra().addActionListener(this);
		v1AltTic.getBtnFiltID().addActionListener(this);
		v1AltTic.getBtnFiltNom().addActionListener(this);
		v1AltTic.getBtnAgregarACompra().addActionListener(this);
		v1AltTic.getBtnResetFilt().addActionListener(this);
		v1AltTic.getBtnEliminar().addActionListener(this);

		v1AltTic.getTxtFiltID().addMouseListener(this);
		v1AltTic.getTxtFiltNom().addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(v1AltTic.getBtnEliminar())) {
			
			if (v1AltTic.getTblDatoArtBaj().getSelectedRow() != -1) {
				
				((DefaultTableModel) v1AltTic.getTblDatoArtBaj().getModel()).removeRow(v1AltTic.getTblDatoArtBaj().getSelectedRow());
			}
		}
		
		if (e.getSource().equals(v1AltTic.getBtnFinalizarCompra())) {

			if (v1AltTic.getTblDatoArtBaj().getRowCount() > 0) {

				String[] opciones = { "Sí", "No" };
				int seguro = JOptionPane.showOptionDialog(v1AltTic,
						"Se efectuará una compra por un total de " + v1AltTic.getTxtFTotal().getText() + " €.\n¿Desea continuar?", "Confirmación",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, null);

				if (seguro == 1) {

				}

				if (seguro == 0) {

					try {
						String sentencia = "INSERT INTO tickets (fechaTicket) VALUES ('" + UtilidadesDB.takeDate()
								+ "');";

						Connection connect = UtilidadesDB.connectDataBase();
						UtilidadesDB.executeIDA(sentencia, connect, false);

						ResultSet rs = UtilidadesDB.executeSelect("SELECT LAST_INSERt_ID();", connect);
						rs.next();
						String idTicket = rs.getString(1);

						for (int i = 0; i < v1AltTic.getTblDatoArtBaj().getRowCount(); i++) {

							String sentInsertCompra = "INSERT INTO compras (idArticuloFK, idTicketFK, cantidadArticulo) VALUES ('"
									+ v1AltTic.getTblDatoArtBaj().getValueAt(i, 0) + "', '" + idTicket + "', '"
									+ v1AltTic.getTblDatoArtBaj().getValueAt(i, 2) + "');";
							UtilidadesDB.executeIDA(sentInsertCompra, connect, false);
							String sentUpdateStock = "UPDATE articulos SET stockArticulo = (stockArticulo - "
									+ v1AltTic.getTblDatoArtBaj().getValueAt(i, 2) + ") WHERE (`idArticulo` = '"
									+ v1AltTic.getTblDatoArtBaj().getValueAt(i, 0) + "')";

							UtilidadesDB.executeIDA(sentUpdateStock, connect, false);
						}

						connect.close();

					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						JOptionPane.showMessageDialog(v1AltTic,
								"ERROR: La compra no se pudo realizar.\nVuelva a intentarlo.", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

					int repetir = JOptionPane.showOptionDialog(v1AltTic,
							"La compra se realizó satisfactorioamente.\n¿Desea realizar otra compra?", "Éxito",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);

					if (repetir == 0) {
						v1AltTic.dispose();
						new Controlador1AltaTicket();
					} else {
						v1AltTic.dispose();
					}

				}
			}
		}

		if (e.getSource().equals(v1AltTic.getBtnAgregarACompra())) {

			if (!v1AltTic.getLstArt().isSelectionEmpty()) {

				try {
					if (Integer.parseInt(v1AltTic.getTxtFCant().getText()) > 0) {

						String sentencia = "SELECT idArticulo, nombreArticulo, precioArticulo, stockArticulo FROM articulos WHERE idArticulo = '"
								+ v1AltTic.getLstArt().getSelectedValue().split(" - ")[0] + "';";

						Connection connect = UtilidadesDB.connectDataBase();

						ResultSet rs = UtilidadesDB.executeSelect(sentencia, connect);

						if (rs.next()) {

							boolean encontrado = false;
							for (int i = 0; i < v1AltTic.getTblDatoArtBaj().getModel().getRowCount()
									& !encontrado; i++) {

								if (v1AltTic.getTblDatoArtBaj().getModel().getValueAt(i, 0).equals(rs.getString(1))) {
									v1AltTic.getTblDatoArtBaj().getModel().setValueAt(
											"" + (Integer.parseInt(v1AltTic.getTxtFCant().getText()) + Integer.parseInt(
													(String) v1AltTic.getTblDatoArtBaj().getModel().getValueAt(i, 2))),
											i, 2);

									if (Integer.parseInt((String) v1AltTic.getTblDatoArtBaj().getValueAt(i, 2)) > rs
											.getInt(4)) {

										v1AltTic.getTblDatoArtBaj().setValueAt(rs.getString(4), i, 2);
									}

									encontrado = true;

								}

							}
							if (!encontrado) {
								((DefaultTableModel) v1AltTic.getTblDatoArtBaj().getModel()).addRow(new String[] {
										rs.getString(1), rs.getString(2),
										"" + Math.min(Integer.parseInt(v1AltTic.getTxtFCant().getText()), rs.getInt(4)),
										rs.getString(3) });

							}
						}
						connect.close();
					}
				} catch (Exception exc) {

					exc.printStackTrace();
					JOptionPane.showMessageDialog(v1AltTic, "El valor de la cantidad introducida es erróneo", "Error",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			
			double total = 0;
			
			for (int i=0;i<v1AltTic.getTblDatoArtBaj().getRowCount(); i++) {
				
				total = total + (Double.parseDouble((String)v1AltTic.getTblDatoArtBaj().getModel().getValueAt(i, 2)) * (Double.parseDouble((String)v1AltTic.getTblDatoArtBaj().getModel().getValueAt(i, 3))));
			}
			
			v1AltTic.getTxtFTotal().setText(total + "");
		}

		// Cuando filtramos por ID
		if (e.getSource().equals(v1AltTic.getBtnFiltID())) {
			if (!v1AltTic.getTxtFiltID().getText().equals("Filtrar por ID")) {
				String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo, ' - Stock: ', stockArticulo) FROM articulos "
						+ "WHERE idArticulo='" + v1AltTic.getTxtFiltID().getText() + "';";
				try {

					((DefaultListModel<String>) v1AltTic.getLstArt().getModel()).clear();
					UtilidadesDB.complexFillJList(sentencia,
							(DefaultListModel<String>) v1AltTic.getLstArt().getModel());
				} catch (Exception exc) {

				}
			}
		}

		// Cuando filtramos por Nombre
		if (e.getSource().equals(v1AltTic.getBtnFiltNom())) {
			if (!v1AltTic.getTxtFiltNom().getText().equals("Filtrar por Nombre")) {
				String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo, ' - Stock: ', stockArticulo) FROM articulos "
						+ "WHERE nombreArticulo LIKE '%" + v1AltTic.getTxtFiltNom().getText() + "%';";
				try {

					((DefaultListModel<String>) v1AltTic.getLstArt().getModel()).clear();
					UtilidadesDB.complexFillJList(sentencia,
							(DefaultListModel<String>) v1AltTic.getLstArt().getModel());
				} catch (Exception exc) {

				}
			}
		}

		if (e.getSource().equals(v1AltTic.getBtnResetFilt())) {

			String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo, ' - Stock: ', stockArticulo) FROM articulos;";
			try {

				((DefaultListModel<String>) v1AltTic.getLstArt().getModel()).clear();
				UtilidadesDB.complexFillJList(sentencia, (DefaultListModel<String>) v1AltTic.getLstArt().getModel());

				v1AltTic.getTxtFiltID().setFont(new Font("Tahoma", Font.ITALIC, 11));
				v1AltTic.getTxtFiltID().setForeground(Color.LIGHT_GRAY);
				v1AltTic.getTxtFiltID().setText("Filtrar por ID");

				v1AltTic.getTxtFiltNom().setFont(new Font("Tahoma", Font.ITALIC, 11));
				v1AltTic.getTxtFiltNom().setForeground(Color.LIGHT_GRAY);
				v1AltTic.getTxtFiltNom().setText("Filtrar por Nombre");

			} catch (Exception exc) {

			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource().equals(v1AltTic.getTxtFiltID())) {

			v1AltTic.getTxtFiltID().setText("");
			v1AltTic.getTxtFiltID().setFont(new Font(null));
			v1AltTic.getTxtFiltID().setForeground(Color.BLACK);
		}

		if (e.getSource().equals(v1AltTic.getTxtFiltNom())) {

			v1AltTic.getTxtFiltNom().setText("");
			v1AltTic.getTxtFiltNom().setFont(new Font(null));
			v1AltTic.getTxtFiltNom().setForeground(Color.BLACK);
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
