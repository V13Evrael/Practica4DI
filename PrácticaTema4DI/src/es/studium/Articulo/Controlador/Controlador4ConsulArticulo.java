package es.studium.Articulo.Controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import es.studium.Articulo.Vista.Vista4ConsulArticulo;

// TODO: Auto-generated Javadoc
/**
 * La clase Controlador4ConsulArticulo.
 * 
 * <p>
 * Esta clase controladora maneja y da funcionalidad a un objeto de la clase
 * {@link Vista4ConsulArticulo} y sus componentes.
 * </p>
 * 
 * @author José Manuel Platero
 */
public class Controlador4ConsulArticulo implements ActionListener {

	/**
	 * El objeto {@link Vista4ConsulArticulo v4ConArt} es un atributo del
	 * Controlador4ConsulArticulo mediante el cual podrá acceder a los elementos de la
	 * vista.
	 */
	Vista4ConsulArticulo v4ConArt;
	
	/**
	 * Instancia un nuevo objeto Controlador4ConsulArticulo, que a su vez instancia
	 * una nueva {@link Vista4ConsulArticulo}, la hace visible y le añade los
	 * listeners correspondientes..
	 */
	public Controlador4ConsulArticulo() {
		
		v4ConArt = new Vista4ConsulArticulo();
		v4ConArt.setVisible(true);
		
		v4ConArt.getBtnSalir().addActionListener(this);
	}

	/**
	 * El método actionPerformed de esta clase, que otorga la funcionalidad a los
	 * diferentes elementos del objeto {@link #v4ConArt}.
	 *
	 * @param e El {@link ActionEvent} que indica la acción que tuvo lugar, usado
	 *          para identificar el elemento de {@link #v4ConArt} que lanzó la
	 *          acción, en este caso solo es necesario.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		v4ConArt.dispose();
	}
}
