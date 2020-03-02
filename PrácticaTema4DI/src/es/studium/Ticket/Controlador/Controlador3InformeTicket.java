package es.studium.Ticket.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import es.studium.Modelo.UtilidadesDB;
import es.studium.Ticket.Vista.Vista3InformeTicket;

public class Controlador3InformeTicket implements ActionListener {

	Vista3InformeTicket v3InfTick;

	public Controlador3InformeTicket() {

		v3InfTick = new Vista3InformeTicket();
		v3InfTick.getBtnCrearInforme().addActionListener(this);

		v3InfTick.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(v3InfTick.getBtnCrearInforme())) {

			v3InfTick.dispose();
			String fechaInicio = v3InfTick.getTxtFechaMin().getText();
			String fechaFin = v3InfTick.getTxtFechaMax().getText();
			try {
				fechaInicio = UtilidadesDB.formatoDateSQL(fechaInicio, "/");
			} catch (ArrayIndexOutOfBoundsException aioobe) {
			}

			try {
				fechaFin = UtilidadesDB.formatoDateSQL(fechaFin, "/");
			} catch (ArrayIndexOutOfBoundsException aioobe) {
			}

			if (v3InfTick.getTxtFechaMin().getText().isBlank()
					| v3InfTick.getTxtFechaMin().getText().equals(null)) {

				fechaInicio = "1900/01/01";
			}
			if (v3InfTick.getTxtFechaMax().getText().isBlank()
					| v3InfTick.getTxtFechaMax().getText().equals(null)) {

				fechaFin = "3000/12/31";
			}
			
			HashMap<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("fechaInicio", fechaInicio);
			parametros.put("fechaFin", fechaFin);

			UtilidadesDB.generaInforme("ReportTicketTiendita", parametros);
			
		}
	}
}
