package es.studium.Articulo.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.studium.Articulo.Vista.Vista3ModifArticulo;

public class Controlador3ModifArticulo implements ActionListener {

	Vista3ModifArticulo v3ModArt;
	boolean errorMsg = false;
	boolean repiteMsg = false;
	boolean seguroMsg = false;
	
	public Controlador3ModifArticulo() {
		
		v3ModArt = new Vista3ModifArticulo();
		v3ModArt.setVisible(true);
		
		v3ModArt.getBtnModifArt().addActionListener(this);
		v3ModArt.getBtnModifSalir().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(v3ModArt.getBtnModifArt())) {
			
			if (errorMsg) {
				
				JOptionPane.showMessageDialog(v3ModArt, "ERROR: La modificación no se pudo realizar.\nVuelva a intentarlo en otor momento.", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
			if (seguroMsg) {
			
				String [] opciones = {"Sí", "No"};
				int seguro = JOptionPane.showOptionDialog(v3ModArt, "¿Está seguro de que desea modificar los datos del artículo seleccionado?", "Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, null);
				
				if (seguro == 1) {
					//Vuelve a la modificación
					
				}
				else if (seguro == 0) {
					
					int repite = JOptionPane.showOptionDialog(v3ModArt, "La modificación se realizó satisfactoriamente.\n¿Desea realizar otra modificación?", "Éxito", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);
					
					if (repite == 1) {
						
						v3ModArt.dispose();
					}
					else if (repite == 0) {
						
						//Vuelve a la modificación
					}
				}
			}
		}
		
		if (e.getSource().equals(v3ModArt.getBtnModifSalir())) {
			
			v3ModArt.dispose();
		}
	
	}
}
