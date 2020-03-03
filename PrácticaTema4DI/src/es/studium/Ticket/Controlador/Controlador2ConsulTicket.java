package es.studium.Ticket.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import es.studium.Modelo.UtilidadesDB;
import es.studium.Ticket.Vista.Vista2ConsultaTicket;

/**
 * La clase Controlador2ConsulTicket.
 * 
 * <p>
 * Esta clase controladora maneja y da funcionalidad a un objeto de la clase
 * {@link Vista2ConsultaTicket} y sus componentes.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Controlador2ConsulTicket implements ActionListener {

	/**
	 * El objeto {@link Vista2ConsultaTicket v2ConTic} es un atributo del
	 * Controlador2ConsulTicket mediante el cual podrá acceder a los elementos de la
	 * vista.
	 */
	Vista2ConsultaTicket v2ConTic;
	
	/**
	 * Instancia un nuevo objeto Controlador2ConsulTicket, que a su vez instancia
	 * una nueva {@link Vista2ConsultaTicket}, la hace visible y le añade los
	 * listeners correspondientes..
	 */
	public Controlador2ConsulTicket() {
		
		v2ConTic = new Vista2ConsultaTicket();
		v2ConTic.setVisible(true);
		
		String sentencia = "SELECT idTicketFK, SUM(cantidadArticulo*precioArticulo), fechaTicket FROM compras, tickets, articulos WHERE idArticulo = idArticuloFK AND idTicketFK = idTicket GROUP BY idTicketFK;";
		UtilidadesDB.complexfillJTable(sentencia, 3, (DefaultTableModel)v2ConTic.getTable().getModel(), 2);
		
		v2ConTic.getBtnSalir().addActionListener(this);
		v2ConTic.getBtnMostrar().addActionListener(this);
	}

	/**
	 * El método actionPerformed de esta clase, que otorga la funcionalidad a los
	 * diferentes elementos del objeto {@link #v2ConTic}.
	 *
	 * @param e El {@link ActionEvent} que indica la acción que tuvo lugar, usado
	 *          para identificar el elemento de {@link #v2ConTic} que lanzó la
	 *          acción.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(v2ConTic.getBtnSalir())) {
			
			v2ConTic.dispose();
		}
		
		if (e.getSource().equals(v2ConTic.getBtnMostrar())) {
			
			if (v2ConTic.getTable().getSelectedRow()!= -1) {
				
				String id = (String)v2ConTic.getTable().getModel().getValueAt(v2ConTic.getTable().getSelectedRow(), 0);
				String total = (String)v2ConTic.getTable().getModel().getValueAt(v2ConTic.getTable().getSelectedRow(), 1);
				String fecha = (String)v2ConTic.getTable().getModel().getValueAt(v2ConTic.getTable().getSelectedRow(), 2);
				new Controlador2ConsulTicketDial(id, fecha, total);	
			}
			
		}
	}
}
