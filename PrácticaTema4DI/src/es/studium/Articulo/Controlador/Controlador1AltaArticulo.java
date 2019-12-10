package es.studium.Articulo.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JOptionPane;

import es.studium.Articulo.Vista.Vista1AltaArticulo;
import es.studium.Modelo.UtilidadesDB;

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
		v1AltArt.getBtnLimpiar().addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(v1AltArt.getBtnAltaArt())) {

			datosMsg = (v1AltArt.getTxtFNombreArt().getText().equals("")
					| v1AltArt.getTxtFPrecioArt().getText().equals("")
					| v1AltArt.getTxtFPrecioArt().getText().equals("")
					| v1AltArt.getTxtADescArt().getText().equals(""));

			if (datosMsg) {
				JOptionPane.showMessageDialog(v1AltArt,
						"Faltan campos por rellenar.\nRevise los datos y vuelva a intentarlo.", "Faltan datos",
						JOptionPane.WARNING_MESSAGE);
			} else {
				
				try {
					String sentencia = "INSERT INTO di4db.articulos (nombreArticulo, precioArticulo, stockArticulo, descripcionArticulo) VALUES ('"
							+ v1AltArt.getTxtFNombreArt().getText() + "', '" + v1AltArt.getTxtFPrecioArt().getText() + "', '"
							+ v1AltArt.getTxtFStockArt().getText() + "', '" + v1AltArt.getTxtADescArt().getText() + "');";

					Connection conect = UtilidadesDB.connectDataBase();
					UtilidadesDB.executeIDA(sentencia, conect);
					conect.close();
					
					String[] opciones = { "Sí", "No" };
					int sN = JOptionPane.showOptionDialog(v1AltArt,
							"El alta se realizó satisfactoriamente.\n¿Desea realizar otra alta?", "Alta realizada",
							JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);

					if (sN == 0) {
						
						v1AltArt.getBtnLimpiar().doClick();
						
					} else if (sN == 1) {
						v1AltArt.dispose();
					}
				} catch (Exception excep) {
					JOptionPane.showMessageDialog(v1AltArt,
							"ERROR: El alta no se pudo realizar.\nRevise los datos y vuelva a intentarlo.", "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		if (e.getSource().equals(v1AltArt.getBtnLimpiar())) {
			
			v1AltArt.getTxtADescArt().setText("");
			v1AltArt.getTxtFNombreArt().setText("");
			v1AltArt.getTxtFPrecioArt().setText("");
			v1AltArt.getTxtFStockArt().setText("");
		}

		if (e.getSource().equals(v1AltArt.getBtnAltaArtSalir())) {

			v1AltArt.dispose();
		}
	}
}
