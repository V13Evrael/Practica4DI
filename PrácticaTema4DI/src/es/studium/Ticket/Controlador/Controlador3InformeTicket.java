package es.studium.Ticket.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import es.studium.Modelo.UtilidadesDB;
import es.studium.Ticket.Vista.Vista3InformeTicket;

/**
 * La clase Controlador3InformeTicket.
 * 
 * <p>
 * Esta clase controladora maneja y da funcionalidad a un objeto de la clase
 * {@link Vista3InformeTicket} y sus componentes.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Controlador3InformeTicket implements ActionListener {

	/**
	 * El objeto {@link Vista3InformeTicket v3InfTick} es un atributo del
	 * Controlador3InformeTicket mediante el cual podrá acceder a los elementos de la
	 * vista.
	 */
	Vista3InformeTicket v3InfTick;

	/**
	 * Instancia un nuevo objeto Controlador3InformeTicket, que a su vez instancia
	 * una nueva {@link Vista3InformeTicket}, la hace visible y le añade los
	 * listeners correspondientes..
	 */
	public Controlador3InformeTicket() {

		v3InfTick = new Vista3InformeTicket();
		v3InfTick.getBtnCrearInforme().addActionListener(this);

		v3InfTick.setVisible(true);

	}

	/**
	 * El método actionPerformed de esta clase, que otorga la funcionalidad a los
	 * diferentes elementos del objeto {@link #v3InfTick}.
	 *
	 * @param e El {@link ActionEvent} que indica la acción que tuvo lugar, usado
	 *          para identificar el elemento de {@link #v3InfTick} que lanzó la
	 *          acción.
	 */
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
