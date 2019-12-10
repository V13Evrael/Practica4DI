package es.studium.Articulo.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.Articulo.Vista.Vista4ConsulArticulo;

public class Controlador4ConsulArticulo implements ActionListener {

	Vista4ConsulArticulo v4ConArt;
	
	public Controlador4ConsulArticulo() {
		
		v4ConArt = new Vista4ConsulArticulo();
		v4ConArt.setVisible(true);
		
		v4ConArt.getBtnSalir().addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		v4ConArt.dispose();
	}
}
