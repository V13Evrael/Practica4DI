package es.studium.Ticket.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.table.DefaultTableModel;

import es.studium.Modelo.UtilidadesDB;
import es.studium.Ticket.Vista.Vista2ConsultaTicket;

public class Controlador2ConsulTicket implements ActionListener {

	Vista2ConsultaTicket v2ConTic;
	
	public Controlador2ConsulTicket() {
		
		v2ConTic = new Vista2ConsultaTicket();
		v2ConTic.setVisible(true);
		
		String sentencia = "SELECT idTicketFK, SUM(cantidadArticulo*precioArticulo), fechaTicket FROM compras, tickets, articulos WHERE idArticulo = idArticuloFK AND idTicketFK = idTicket GROUP BY idTicketFK;";
		UtilidadesDB.complexfillJTable(sentencia, 3, (DefaultTableModel)v2ConTic.getTable().getModel(), 2);
		
		v2ConTic.getBtnSalir().addActionListener(this);
		v2ConTic.getBtnMostrar().addActionListener(this);
	}

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
