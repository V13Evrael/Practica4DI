package es.studium.Ticket.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import es.studium.Modelo.UtilidadesDB;
import es.studium.Ticket.Vista.Vista2ConsultaTicketDial;

/**
 * La clase Controlador2ConsulTicketDial.
 * 
 * <p>
 * Esta clase controladora maneja y da funcionalidad a un objeto de la clase
 * {@link Vista2ConsultaTicketDial} y sus componentes.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Controlador2ConsulTicketDial implements ActionListener {

	/**
	 * El objeto {@link Vista2ConsultaTicketDial v2ConTickDia} es un atributo del
	 * Controlador2ConsulTicketDial mediante el cual podrá acceder a los elementos de la
	 * vista.
	 */
	Vista2ConsultaTicketDial v2ConTickDia;

	/**
	 * Instancia un nuevo objeto Controlador2ConsulTicketDial, que a su vez instancia
	 * una nueva {@link Vista2ConsultaTicketDial}, la hace visible y le añade los
	 * listeners correspondientes..
	 * @param id El id que corresponde al Ticket que debe abrirse.
	 * @param fecha La fecha del Ticket.
	 * @param total El total de la compra.
	 */
	public Controlador2ConsulTicketDial(String id, String fecha, String total) {

		v2ConTickDia = new Vista2ConsultaTicketDial(id, fecha, total);

		String sentencia = "SELECT idArticulo, nombreArticulo, cantidadArticulo, precioArticulo, (cantidadArticulo*precioArticulo) FROM articulos, compras WHERE idArticulo = idArticuloFK AND idTicketFK = "
				+ id + ";";

		UtilidadesDB.complexfillJTable(sentencia, 5, (DefaultTableModel) v2ConTickDia.getTable().getModel());
		

		v2ConTickDia.setVisible(true);

		v2ConTickDia.getBtnVolver().addActionListener(this);
	}

	/**
	 * El método actionPerformed de esta clase, que otorga la funcionalidad a los
	 * diferentes elementos del objeto {@link #v2ConTickDia}.
	 *
	 * @param e El {@link ActionEvent} que indica la acción que tuvo lugar, usado
	 *          para identificar el elemento de {@link #v2ConTickDia} que lanzó la
	 *          acción.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		v2ConTickDia.dispose();

	}
}
