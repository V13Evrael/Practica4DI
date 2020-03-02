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

public class ControladorPrincipal  implements ActionListener {

	VistaPrincipal vp;
	
	public ControladorPrincipal() {
		
		//Se configura la Vista Principal
		vp = new VistaPrincipal();
		vp.setVisible(true);
		vp.setLocationRelativeTo(null);
		
		//Se añaden listeners a los menú item de Artículos
		vp.getMnItAltaArt().addActionListener(this);
		vp.getMnItModArt().addActionListener(this);
		vp.getMnItBajaArt().addActionListener(this);
		vp.getMnItConArt().addActionListener(this);
		vp.getMnItInfArt().addActionListener(this);

		//Se añaden listeners a los menú item de Tickets
		vp.getMnItAltaTick().addActionListener(this);
		vp.getMnItConTick().addActionListener(this);
		vp.getMnItInfTick().addActionListener(this);
		
	}

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
