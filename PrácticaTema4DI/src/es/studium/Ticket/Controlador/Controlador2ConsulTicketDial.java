package es.studium.Ticket.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import es.studium.Modelo.UtilidadesDB;
import es.studium.Ticket.Vista.Vista2ConsultaTicketDial;

public class Controlador2ConsulTicketDial implements ActionListener {

	Vista2ConsultaTicketDial v2ConTickDia;

	public Controlador2ConsulTicketDial(String id, String fecha, String total) {

		v2ConTickDia = new Vista2ConsultaTicketDial(id, fecha, total);

		String sentencia = "SELECT idArticulo, nombreArticulo, cantidadArticulo, precioArticulo, (cantidadArticulo*precioArticulo) FROM articulos, compras WHERE idArticulo = idArticuloFK AND idTicketFK = "
				+ id + ";";

		UtilidadesDB.complexfillJTable(sentencia, 5, (DefaultTableModel) v2ConTickDia.getTable().getModel());
		

		v2ConTickDia.setVisible(true);

		v2ConTickDia.getBtnVolver().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		v2ConTickDia.dispose();

	}
}
