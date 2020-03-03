package es.studium.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import es.studium.Articulo.Controlador.Controlador1AltaArticulo;
import es.studium.Articulo.Controlador.Controlador2BajaArticulo;
import es.studium.Articulo.Controlador.Controlador3ModifArticulo;
import es.studium.Articulo.Controlador.Controlador4ConsulArticulo;
import es.studium.Modelo.UtilidadesDB;
import es.studium.Ticket.Controlador.Controlador1AltaTicket;
import es.studium.Ticket.Controlador.Controlador2ConsulTicket;
import es.studium.Ticket.Controlador.Controlador3InformeTicket;

/**
 * La clase ControladorPrincipal.
 * 
 * <p>
 * Esta clase controladora maneja y da funcionalidad a un objeto de la clase
 * {@link VistaPrincipal} y sus componentes.
 * </p>
 * 
 * @author Jos� Manuel Platero
 */
public class ControladorPrincipal implements ActionListener {

	/**
	 * El objeto {@link VistaPrincipal vp} es un atributo del ControladorPrincipal
	 * mediante el cual podr� acceder a los elementos de la vista.
	 */
	VistaPrincipal vp;

	/**
	 * Instancia un nuevo ControladorPrincipal, que a su vez instancia una nueva
	 * {@link VistaPrincipal}, la hace visible y le a�ade los listeners
	 * correspondientes.
	 */
	public ControladorPrincipal() {

		// Se configura la Vista Principal
		vp = new VistaPrincipal();
		vp.setVisible(true);
		vp.setLocationRelativeTo(null);

		// Se a�aden listeners a los men� item de Art�culos
		vp.getMnItAltaArt().addActionListener(this);
		vp.getMnItModArt().addActionListener(this);
		vp.getMnItBajaArt().addActionListener(this);
		vp.getMnItConArt().addActionListener(this);
		vp.getMnItInfArt().addActionListener(this);

		// Se a�aden listeners a los men� item de Tickets
		vp.getMnItAltaTick().addActionListener(this);
		vp.getMnItConTick().addActionListener(this);
		vp.getMnItInfTick().addActionListener(this);

	}

	/**El m�todo actionPerformed de esta clase, que otorga la funcionalidad a los diferentes elementos del objeto {@link #vp}.
	 *
	 * @param e El {@link ActionEvent} que indica la acci�n que tuvo lugar, usado para identificar el elemento de {@link #vp} que lanz� la acci�n. 
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource().equals(vp.getMnItAltaArt())) {

			new Controlador1AltaArticulo();
		}

		if (e.getSource().equals(vp.getMnItModArt())) {

			new Controlador3ModifArticulo();
		}

		if (e.getSource().equals(vp.getMnItBajaArt())) {

			new Controlador2BajaArticulo();
		}

		if (e.getSource().equals(vp.getMnItConArt())) {

			new Controlador4ConsulArticulo();
		}

		if (e.getSource().equals(vp.getMnItAltaTick())) {

			new Controlador1AltaTicket();
		}

		if (e.getSource().equals(vp.getMnItConTick())) {

			new Controlador2ConsulTicket();
		}

		if (e.getSource().equals(vp.getMnItInfTick())) {

			new Controlador3InformeTicket();
		}

		if (e.getSource().equals(vp.getMnItInfArt())) {

			UtilidadesDB.generaInforme("ReportArticulosTiendita", new HashMap<String, Object>());
		}
	}
}
