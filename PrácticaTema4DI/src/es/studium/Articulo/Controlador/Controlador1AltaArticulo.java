package es.studium.Articulo.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.studium.Articulo.Vista.Vista1AltaArticulo;

public class Controlador1AltaArticulo implements ActionListener {

	Vista1AltaArticulo v1AltArt;
	boolean errorMsg = false;
	boolean datosMsg = false;
	boolean otroAltaMsg = false;

	public Controlador1AltaArticulo() {

		v1AltArt = new Vista1AltaArticulo();
		v1AltArt.setVisible(true);
		
		v1AltArt.getBtnAltaArt().addActionListener(this);
		v1AltArt.getBtnAltaArtSalir().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(v1AltArt.getBtnAltaArt())) {

			if (errorMsg) {

				JOptionPane.showMessageDialog(v1AltArt,
						"ERROR: El alta no se pudo realizar.\nRevise los datos y vuelva a intentarlo.", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

			if (datosMsg) {

				JOptionPane.showMessageDialog(v1AltArt,
						"Faltan campos por rellenar.\nRevise los datos y vuelva a intentarlo.", "Faltan datos",
						JOptionPane.WARNING_MESSAGE);
			}

			if (true) {

				String [] opciones = {"Sí", "No"};
				int sN = JOptionPane.showOptionDialog(v1AltArt,
						"El alta se realizó satisfactoriamente.\n¿Desea realizar otra alta?", "Alta realizada",
						JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);

				if (sN == 0) {
					// Vuelve al alta y limpia los datos
				} else if (sN == 1) {
					v1AltArt.dispose();
				}
			}
		}
		
		if (e.getSource().equals(v1AltArt.getBtnAltaArtSalir())){
			
			v1AltArt.dispose();
		}
	}
}
