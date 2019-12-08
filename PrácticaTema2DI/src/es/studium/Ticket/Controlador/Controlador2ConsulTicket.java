package es.studium.Ticket.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.Ticket.Vista.Vista2ConsultaTicket;

public class Controlador2ConsulTicket implements ActionListener {

	Vista2ConsultaTicket v2ConTic;
	
	public Controlador2ConsulTicket() {
		
		v2ConTic = new Vista2ConsultaTicket();
		v2ConTic.setVisible(true);
		
		v2ConTic.getBtnSalir().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource().equals(v2ConTic.getBtnSalir())) {
			
			v2ConTic.dispose();
		}	
	}
}
