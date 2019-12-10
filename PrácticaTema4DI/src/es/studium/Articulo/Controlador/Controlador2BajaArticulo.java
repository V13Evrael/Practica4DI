package es.studium.Articulo.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.studium.Articulo.Vista.Vista2BajaArticulo;

public class Controlador2BajaArticulo implements ActionListener {

	Vista2BajaArticulo v2BajArt;
	boolean errorMsg = false;
	boolean seguroMsg = false;
	boolean otraBajaMsg = false;

	public Controlador2BajaArticulo() {

		v2BajArt = new Vista2BajaArticulo();
		v2BajArt.setVisible(true);

		v2BajArt.getBtnBajaArt().addActionListener(this);
		v2BajArt.getBtnBajaArtSalir().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(v2BajArt.getBtnBajaArt())) {

			if (errorMsg) {

				JOptionPane.showMessageDialog(v2BajArt,
						"ERROR: La baja no se pudo realizar.\nRevise los datos y vuelva a intentarlo.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			if (seguroMsg) {

				String[] opciones = { "Sí", "No" };
				int seguro = JOptionPane.showOptionDialog(v2BajArt,
						"¿Está seguro/a de que desea dar de baja el artículo \"NombreArtículo1\"?", "Confirmación",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, null);
				if (seguro == 1) {
					// Vuelve a la baja

				} else if (seguro == 0) {

					if (!otraBajaMsg) {

						int repite = JOptionPane.showOptionDialog(v2BajArt,
								"La baja se realizó satisfactoriamente.\n¿Desea realizar otra baja?", "Baja realizada",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);

						if (repite == 1) {
							v2BajArt.dispose();
						} else if (repite == 0) {
							// Vuelve a la baja
						}
					}
				}
			}
		}

		if (e.getSource().equals(v2BajArt.getBtnBajaArtSalir())) {

			v2BajArt.dispose();
		}
	}

}
