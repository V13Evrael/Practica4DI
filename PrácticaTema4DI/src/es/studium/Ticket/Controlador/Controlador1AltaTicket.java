package es.studium.Ticket.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import es.studium.Ticket.Vista.Vista1AltaTicket;

public class Controlador1AltaTicket implements ActionListener {

	Vista1AltaTicket v1AltTic;
	boolean errorMsg = false;
	boolean seguroMsg = false;
	boolean repetirMsg = false;

	public Controlador1AltaTicket() {

		v1AltTic = new Vista1AltaTicket();
		v1AltTic.setVisible(true);
		
		v1AltTic.getBtnFinalizarCompra().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(v1AltTic.getBtnFinalizarCompra())) {

			if (!errorMsg) {

				JOptionPane.showMessageDialog(v1AltTic, "ERROR: La compra no se pudo realizar.\nVuelva a intentarlo.",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

			if (!seguroMsg) {

				String [] opciones = {"Sí", "No"};
				int seguro = JOptionPane.showOptionDialog(v1AltTic,
						"Se efectuará una compra por un total de 130€.\n¿Desea continuar?", "Confirmación",
						JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, opciones, null);

				if (seguro == 1) {
					
					// Vuelve al Alta Ticket conservando los datos
				}
				
				if (seguro == 0) {
					
					if (!repetirMsg) {

						int repetir = JOptionPane.showOptionDialog(v1AltTic,
								"La compra se realizó satisfactorioamente.\n¿Desea realizar otra compra?", "Éxito",
								JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, null);

						if (repetir == 1) {
							v1AltTic.dispose();
						}

						if (repetir == 0) {
							// Vuelve al Alta Ticket borrando los datos
						}
					}
				}
			}

			
		}
	}
}
