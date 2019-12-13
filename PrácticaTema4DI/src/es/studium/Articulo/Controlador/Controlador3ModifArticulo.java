package es.studium.Articulo.Controlador;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import es.studium.Articulo.Vista.Vista3ModifArticulo;
import es.studium.Modelo.UtilidadesDB;

public class Controlador3ModifArticulo implements ActionListener, ListSelectionListener, MouseListener {

	Vista3ModifArticulo v3ModArt;
	boolean errorMsg = false;
	boolean repiteMsg = false;
	boolean seguroMsg = false;

	public Controlador3ModifArticulo() {

		v3ModArt = new Vista3ModifArticulo();
		v3ModArt.setVisible(true);

		String sentencia = "SELECT concat(idArticulo, ' - ', nombreArticulo) FROM articulos;";
		UtilidadesDB.complexFillJList(sentencia, (DefaultListModel<String>) v3ModArt.getLstArt().getModel());

		v3ModArt.getBtnFiltID().addActionListener(this);

		v3ModArt.getBtnModifArt().addActionListener(this);
		v3ModArt.getBtnModifSalir().addActionListener(this);
		v3ModArt.getBtnResetFilt().addActionListener(this);
		v3ModArt.getBtnFiltID().addActionListener(this);
		v3ModArt.getBtnFiltNom().addActionListener(this);
		v3ModArt.getBtnFiltPrecio().addActionListener(this);
		v3ModArt.getBtnFiltStock().addActionListener(this);
		v3ModArt.getBtnActivCampos().addActionListener(this);

		v3ModArt.getLstArt().addListSelectionListener(this);

		v3ModArt.getTxtFiltID().addMouseListener(this);
		v3ModArt.getTxtFiltNom().addMouseListener(this);
		v3ModArt.getTxtFiltPrecio().addMouseListener(this);
		v3ModArt.getTxtFiltStock().addMouseListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Botón Filtrar nombre:
		if (e.getSource().equals(v3ModArt.getBtnFiltID())) {
			if (!v3ModArt.getTxtFiltID().getText().equals("Filtrar por ID")) {
				String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos "
						+ "WHERE idArticulo='" + v3ModArt.getTxtFiltID().getText() + "';";
				try {

					((DefaultListModel<String>) v3ModArt.getLstArt().getModel()).clear();
					UtilidadesDB.complexFillJList(sentencia,
							(DefaultListModel<String>) v3ModArt.getLstArt().getModel());
				} catch (Exception exc) {

				}
			}
		}

		// Cuando filtramos por Nombre
		if (e.getSource().equals(v3ModArt.getBtnFiltNom())) {
			if (!v3ModArt.getTxtFiltNom().getText().equals("Filtrar por Nombre")) {
				String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos "
						+ "WHERE nombreArticulo LIKE '%" + v3ModArt.getTxtFiltNom().getText() + "%';";
				try {

					((DefaultListModel<String>) v3ModArt.getLstArt().getModel()).clear();
					UtilidadesDB.complexFillJList(sentencia,
							(DefaultListModel<String>) v3ModArt.getLstArt().getModel());
				} catch (Exception exc) {

				}
			}
		}

		// Cuando filtramos por Nombre
		if (e.getSource().equals(v3ModArt.getBtnFiltPrecio())) {
			if (!v3ModArt.getTxtFiltPrecio().getText().equals("Filtrar por Precio")) {
				String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos "
						+ "WHERE precioArticulo = '" + v3ModArt.getTxtFiltPrecio().getText() + "';";
				try {

					((DefaultListModel<String>) v3ModArt.getLstArt().getModel()).clear();
					UtilidadesDB.complexFillJList(sentencia,
							(DefaultListModel<String>) v3ModArt.getLstArt().getModel());
				} catch (Exception exc) {

				}
			}
		}

		// Cuando filtramos por Stock
		if (e.getSource().equals(v3ModArt.getBtnFiltStock())) {
			if (!v3ModArt.getTxtFiltStock().getText().equals("Filtrar por Stock")) {
				String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos "
						+ "WHERE stockArticulo = '" + v3ModArt.getTxtFiltStock().getText() + "';";
				try {

					((DefaultListModel<String>) v3ModArt.getLstArt().getModel()).clear();
					UtilidadesDB.complexFillJList(sentencia,
							(DefaultListModel<String>) v3ModArt.getLstArt().getModel());
				} catch (Exception exc) {

				}
			}
		}

		// Para modificar el alta
		if (e.getSource().equals(v3ModArt.getBtnModifArt())) {

			if (v3ModArt.getTxtFNombreArt().isEditable()) {

				JOptionPane.showMessageDialog(v3ModArt,
						"Para proceder en una modificación, revise que los datos son correctos y pulse en Desactivar Campos");

			} else if (!v3ModArt.getLstArt().isSelectionEmpty()) {

				String sentencia = "UPDATE di4db.articulos SET nombreArticulo = '"
						+ v3ModArt.getTxtFNombreArt().getText() + "', precioArticulo = '"
						+ v3ModArt.getTxtFPrecioArt().getText() + "', stockArticulo = '"
						+ v3ModArt.getTxtFStockArt().getText() + "', descripcionArticulo = '"
						+ v3ModArt.getTxtADescArt().getText() + "' WHERE (idArticulo = '"
						+ v3ModArt.getLstArt().getSelectedValue().split(" - ")[0] + "');";

				try {

					String[] opciones = { "Sí", "No" };
					int seguro = JOptionPane.showOptionDialog(v3ModArt,
							"¿Está seguro de que desea modificar los datos del artículo seleccionado?", "Confirmación",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, null);

					if (seguro == 0) {

						UtilidadesDB.executeIDA(sentencia, UtilidadesDB.connectDataBase());

						int repite = JOptionPane.showOptionDialog(v3ModArt,
								"La modificación se realizó satisfactoriamente.\n¿Desea realizar otra modificación?",
								"Éxito", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones,
								null);

						if (repite == 1) {

							v3ModArt.dispose();
						} else if (repite == 0) {

							// Vuelve a la modificación
						}

					}

				} catch (Exception exc) {

					JOptionPane.showMessageDialog(v3ModArt,
							"ERROR: La modificación no se pudo realizar.\nVuelva a intentarlo en otor momento.",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}

		// Al pulsar el botón Salir
		if (e.getSource().equals(v3ModArt.getBtnModifSalir())) {

			v3ModArt.dispose();
		}

		// Para resetear el filtro
		if (e.getSource().equals(v3ModArt.getBtnResetFilt())) {

			String sentencia = "SELECT concat(idArticulo,' - ', nombreArticulo) FROM articulos;";

			try {

				((DefaultListModel<String>) v3ModArt.getLstArt().getModel()).clear();
				UtilidadesDB.complexFillJList(sentencia, (DefaultListModel<String>) v3ModArt.getLstArt().getModel());

				v3ModArt.getTxtFiltID().setFont(new Font("Tahoma", Font.ITALIC, 11));
				v3ModArt.getTxtFiltID().setForeground(Color.LIGHT_GRAY);
				v3ModArt.getTxtFiltID().setText("Filtrar por ID");

				v3ModArt.getTxtFiltNom().setFont(new Font("Tahoma", Font.ITALIC, 11));
				v3ModArt.getTxtFiltNom().setForeground(Color.LIGHT_GRAY);
				v3ModArt.getTxtFiltNom().setText("Filtrar por nombre");

				v3ModArt.getTxtFiltPrecio().setFont(new Font("Tahoma", Font.ITALIC, 11));
				v3ModArt.getTxtFiltPrecio().setForeground(Color.LIGHT_GRAY);
				v3ModArt.getTxtFiltPrecio().setText("Filtrar por precio");

				v3ModArt.getTxtFiltStock().setFont(new Font("Tahoma", Font.ITALIC, 11));
				v3ModArt.getTxtFiltStock().setForeground(Color.LIGHT_GRAY);
				v3ModArt.getTxtFiltStock().setText("Filtrar por stock");

			} catch (Exception exc) {

			}
		}

		if (e.getSource().equals(v3ModArt.getBtnActivCampos())) {

			if (v3ModArt.getTxtFNombreArt().isEditable()) {

				v3ModArt.getTxtADescArt().setEditable(false);
				v3ModArt.getTxtADescArt().setBackground(new Color(240, 240, 240, 240));
				v3ModArt.getTxtFNombreArt().setEditable(false);
				v3ModArt.getTxtFPrecioArt().setEditable(false);
				v3ModArt.getTxtFStockArt().setEditable(false);
				v3ModArt.getBtnActivCampos().setText("Activar campos");

			} else {

				v3ModArt.getTxtADescArt().setEditable(true);
				v3ModArt.getTxtADescArt().setBackground(Color.WHITE);
				v3ModArt.getTxtFNombreArt().setEditable(true);
				v3ModArt.getTxtFPrecioArt().setEditable(true);
				v3ModArt.getTxtFStockArt().setEditable(true);
				v3ModArt.getBtnActivCampos().setText("Desactivar campos");
			}

		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {

		String idArt = v3ModArt.getLstArt().getSelectedValue().split(" - ")[0];
		String sentencia = "SELECT nombreArticulo, precioArticulo, stockArticulo, descripcionArticulo FROM articulos WHERE idArticulo = '"
				+ idArt + "';";

		try {
			Connection c = UtilidadesDB.connectDataBase();
			ResultSet rs = UtilidadesDB.executeSelect(sentencia, c);
			rs.next();
			v3ModArt.getTxtFNombreArt().setText(rs.getString(1));
			v3ModArt.getTxtFPrecioArt().setText(rs.getString(2));
			v3ModArt.getTxtFStockArt().setText(rs.getString(3));
			v3ModArt.getTxtADescArt().setText(rs.getString(4));
			c.close();

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		if (e.getSource().equals(v3ModArt.getTxtFiltID())) {

			v3ModArt.getTxtFiltID().setText("");
			v3ModArt.getTxtFiltID().setFont(new Font(null));
			v3ModArt.getTxtFiltID().setForeground(Color.BLACK);
		}

		if (e.getSource().equals(v3ModArt.getTxtFiltNom())) {

			v3ModArt.getTxtFiltNom().setText("");
			v3ModArt.getTxtFiltNom().setFont(new Font(null));
			v3ModArt.getTxtFiltNom().setForeground(Color.BLACK);
		}
		if (e.getSource().equals(v3ModArt.getTxtFiltPrecio())) {

			v3ModArt.getTxtFiltPrecio().setText("");
			v3ModArt.getTxtFiltPrecio().setFont(new Font(null));
			v3ModArt.getTxtFiltPrecio().setForeground(Color.BLACK);
		}
		if (e.getSource().equals(v3ModArt.getTxtFiltStock())) {

			v3ModArt.getTxtFiltStock().setText("");
			v3ModArt.getTxtFiltStock().setFont(new Font(null));
			v3ModArt.getTxtFiltStock().setForeground(Color.BLACK);
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