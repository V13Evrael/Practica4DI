package es.studium.Modelo;

import java.awt.Desktop;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 * La clase UtilidadesDB.
 * <p>
 * Esta clase contiene en su interior una serie de m�todos que nos las clases Controladoras usar�n para otorgar funcionalidad a los elementos de las Vistas.
 * </p>
 * 
 * @author Jos� Manuel Platero
 */
public class UtilidadesDB {

	/**
	 * Este m�todo conecta con la base de datos.
	 *
	 * @return un objeto {@link Connection} con los datos adecuados.
	 * @throws ClassNotFoundException Una excepci�n cuando no se encuentra el Driver.
	 * @throws SQLException Una excepci�n cuando la conexi�n no se puede llevar a cabo.
	 */
	public static Connection connectDataBase() throws ClassNotFoundException, SQLException {

		Connection resultado = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/di4db? autoReconnect=true&useSSL=false";
		String loginBD = "remotoTiendita";
		String passwordBD = "Studium2019;";

		// Cargar el Driver
		Class.forName(driver);

		// Establecer la conexi�n con la base de datos
		resultado = DriverManager.getConnection(url, loginBD, passwordBD);

		return resultado;
	}

	// Este m�todo genera un Select a partir de los elementos b�sicos si se quiere
	/**
	 * Este m�todo genera un Select a partir de los elementos b�sicos.
	 *
	 * @param elements Los elementos que se quieren introducir en el Select.
	 * @param fromTable la tabla o tablas de las que se quieren coger los elementos. 
	 * @param where las cl�usulas where de la sentencia.
	 * @return Un {@link String} con la sentencia Select formada.
	 */
	// ordenar, debe introducirse a continuaci�n del Where.
	public static String generateSelect(String elements, String fromTable, String where) {

		String resultado = "SELECT " + elements + " FROM " + fromTable + " WHERE " + where + ";";
		return resultado;
	}

	/**
	 * Coge la fecha actual del sistema.
	 *
	 * @return Un {@link String} con la fecha en formato YYYY/mm/dd.
	 */
	// M�todo para recoger la fecha actual.
	public static String takeDate() {
		Calendar calendario = new GregorianCalendar();
		String resultado = "";
		String year = "" + calendario.get(Calendar.YEAR);
		String month = "" + (calendario.get(Calendar.MONTH) + 1);
		String day = "" + calendario.get(Calendar.DAY_OF_MONTH);

		if (month.length() == 1) {
			month = "0" + month;
		}

		if (day.length() == 1) {
			day = "0" + day;
		}

		resultado = year + "/" + month + "/" + day;
		return resultado;
	}

	/**
	 * Cambia el Formato de una fecha de americano a castellano y viceversa.
	 *
	 * @param fecha Un {@link String} con la fecha que se desea cambiar
	 * @return Un {@link String} con la fecha cambiada.
	 */
	public static String formatoDateSQL(String fecha) {
		String resultado = fecha;
		String[] listaResultado = resultado.split("/");
		resultado = listaResultado[2] + "/" + listaResultado[1] + "/" + listaResultado[0];
		return resultado;
	}
	
	/**
	 * Cambia el Formato de una fecha de americano a castellano y viceversa.
	 *
	 * @param fecha Un {@link String} con la fecha que se desea cambiar.
	 * @param splitter El caracter que separa el mes, del d�a y el a�o.
	 * @return Un {@link String} conla fecha cambiada.
	 */
	public static String formatoDateSQL(String fecha, String splitter) {
		String resultado = fecha;
		String[] listaResultado = resultado.split(splitter);
		resultado = listaResultado[2] + splitter + listaResultado[1] + splitter + listaResultado[0];
		return resultado;
	}

	/**
	 * Desconecta una conexi�n si no lo est� ya.
	 *
	 * @param c La conexi�n que se desea cerrar.
	 */
	// M�todo para cerrar una conexi�n.
	public static void disconnectGestion(Connection c) {
		try {
			if (!c.isClosed()) {
				c.close();
			}
		} catch (SQLException e) {

			System.out.println("Error al cerrar " + e.toString());
		}
	}

	/**
	 * Ejecuta una sentencia Select sobre una conexi�n con una base de datos.
	 *
	 * @param sentencia El select que se desea lanzar.
	 * @param c la conexi�n sobre la que se quiere lanzar el select.
	 * @return El resultado de dicho select guardado en un {@link ResultSet}.
	 */
	// M�todo para ejecutar una sentencia Select.
	public static ResultSet executeSelect(String sentencia, Connection c) {
		Statement statement = null;
		ResultSet rs = null;
		// Preparar el statement
		try {
			statement = c.createStatement();
			rs = statement.executeQuery(sentencia);
		} catch (SQLException e) {
			System.out.println("Error en la sentencia SQL");
		}
		return rs;
	}

	/**
	 * Ejecuta una de las operaciones de Insert, Delete y Update
	 *
	 * @param sentencia La sentencia que se desea lanzar.
	 * @param c la conexi�n sobre la que se desea lanzar.
	 * @throws SQLException Una excepci�n {@link SQLException} si hay alg�n error SQL.
	 */
	// M�todo para ejecutar un CUD de CRUD.
	public static void executeIDA(String sentencia, Connection c) throws SQLException {
		Statement statement = null;
		// Preparar el statement

		statement = c.createStatement();
		statement.executeUpdate(sentencia);

		disconnectGestion(c);
	}

	/**
	 * Ejecuta una de las operaciones de Insert, Delete y Update
	 *
	 * @param sentencia La sentencia que se desea lanzar.
	 * @param c la conexi�n sobre la que se desea lanzar.
	 * @param cerrarCon un boolean que marca si se quiere cerrar la conexi�n.
	 * @throws SQLException Una excepci�n {@link SQLException} si hay alg�n error SQL.
	 */
	public static void executeIDA(String sentencia, Connection c, boolean cerrarCon) throws SQLException {

		if (cerrarCon) {
			executeIDA(sentencia, c);
		} else {
			Statement statement = null;
			// Preparar el statement

			statement = c.createStatement();
			statement.executeUpdate(sentencia);
		}
	}

	// Este m�todo rellena un ComboBox utilizando una sentencia SQL guardada en un
	// resultSet.
	// En la lista de Integers se indican qu� elementos de la sentencia se van a
	/**
	 * Este m�todo rellena un ComboBox utilizando una sentencia SQL guardada en un
	 * ResultSet
	 *
	 * @param rs El {@link ResultSet} con los datos.
	 * @param c El {@link JComboBox} donde se guardar�n los datos.
	 * @param lista Un array de enteros con n�meros de 0 hasta la cantidad de columnas del rs.
	 */
	// coger y en qu� orden se colocar�n.
	public static void fillComboBoxRS(ResultSet rs, JComboBox<String> c, Integer[] lista) {
		try {
			while (rs.next()) {
				String resultado = "";
				for (Integer elem : lista) {
					if (!elem.equals(lista[lista.length - 1])) {
						resultado = resultado + rs.getString(elem) + " - ";
					} else {
						resultado = resultado + rs.getString(elem);
					}
				}
				c.addItem(resultado);
			}
		} catch (Exception e) {
			System.out.println("Se ha producido un error");
			e.printStackTrace();
		}
	}

	// Este m�todo une varios de los m�todos anteriores para hacerlo todo en uno
	/**
	 * Este m�todo une varios de los anteriores para hacerlo en una sola instrucci�n.
	 * Se usan: {@link #connectDataBase()}, {@link #executeSelect(String, Connection)}, {@link #fillComboBoxRS(ResultSet, JComboBox, Integer[])}, {@link #disconnectGestion(Connection)}.
	 *
	 * @param sentencia La sentencia para el m�todo executeSelect.
	 * @param cmb El {@link JComboBox} para el m�todo fillComboBoxRS.
	 * @param lista la lista usada en el m�todo fillComboBoxRS.
	 */
	// sola l�nea de c�digo.
	public static void complexFillCB(String sentencia, JComboBox<String> cmb, Integer[] lista) {
		Connection c;
		try {
			c = connectDataBase();
			ResultSet rs = executeSelect(sentencia, c);
			fillComboBoxRS(rs, cmb, lista);
			disconnectGestion(c);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * Un m�todo para rellenar una {@link JTable} con una sentencia Select.
	 *
	 * @param sentencia La sentencia Select usada por el m�todo {@link #executeSelect(String, Connection)}
	 * @param columnas el n�mero de columnas que se quieren coger.
	 * @param tabla El {@link DefaultTableModel} donde se guardar�n los elementos extra�dos.
	 */
	public static void complexfillJTable(String sentencia, Integer columnas, DefaultTableModel tabla) {
		Connection c;

		try {
			c = connectDataBase();
			ResultSet rs = executeSelect(sentencia, c);
			String[] filas = new String[columnas];

			while (rs.next()) {
				for (int i = 0; i < columnas; i++) {
					try {
						filas[i] = rs.getString(i + 1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				tabla.addRow(filas);
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Un m�todo similar {@link #complexfillJTable(String, Integer, DefaultTableModel)}, pero en el que se indica en qu� columna hay una fecha.
	 *
	 * @param sentencia La sentencia Select usada por el m�todo {@link #executeSelect(String, Connection)}
	 * @param columnas el n�mero de columnas que se quieren coger.
	 * @param tabla El {@link DefaultTableModel} donde se guardar�n los elementos extra�dos.
	 * @param columnaFecha la columna donde se encuentra la fecha.
	 */
	public static void complexfillJTable(String sentencia, Integer columnas, DefaultTableModel tabla,
			Integer columnaFecha) {

		Connection c;

		try {
			c = connectDataBase();
			ResultSet rs = executeSelect(sentencia, c);
			String[] filas = new String[columnas];

			while (rs.next()) {
				for (int i = 0; i < columnas; i++) {
					try {
						if (columnaFecha != i) {
							filas[i] = rs.getString(i + 1);
						} else {
							System.out.println(rs.getString(i+1));
							filas[i] = UtilidadesDB.formatoDateSQL(rs.getString(i + 1), "-");
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				tabla.addRow(filas);
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Para hacerlo m�s sencillo La sentencia debe devolver un solo String con los
	/**
	 * Un m�todo para rellenar una {@link JList} con una sentencia Select.
	 * 	 *
	 * @param sentencia la sentencia Select usada por el m�todo {@link #executeSelect(String, Connection)}.
	 * @param lista el {@link DefaultListModel} donde se guardar�n los elementos que devuelve la sentencia. 
	 */
	// datos colocados de la manera adecuada.
	public static void complexFillJList(String sentencia, DefaultListModel<String> lista) {

		Connection c;

		try {
			c = connectDataBase();
			ResultSet rs = executeSelect(sentencia, c);
			while (rs.next()) {
				lista.addElement(rs.getString(1));
			}
			c.close();
		} catch (Exception e) {
		}
	}
	
	/**
	 * Genera un informe PDF y .jasper en base a un documento .jrxml pasado por par�metro.
	 *
	 * @param nombreInforme El nombre del archivo .jrxml (sin la extensi�n).
	 * @param parametros un {@link HashMap} con parejas los par�metros que debe recibir el archivo .jrxml (en formato Clave, Valor).
	 */
	public static void generaInforme(String nombreInforme, HashMap<String, Object> parametros) {
		try {
			// Compilar el informe generando fichero jasper
			JasperCompileManager.compileReportToFile(nombreInforme + ".jrxml");
			System.out.println("Fichero" + nombreInforme + ".jasper generado CORRECTAMENTE!");
			// Objeto para guardar par�metros necesarios para el informe
			
			// Cargar el informe compilado
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(nombreInforme + ".jasper");
			// Conectar a la base de datos para sacar la informaci�n
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost:3306/di4db?useSSL=false";
			String usuarioDB = "remotoTiendita";
			String passwordDB = "Studium2019;";
			Connection conexion = DriverManager.getConnection(servidor, usuarioDB, passwordDB);

			// Completar el informe con los datos de la base de datos
			JasperPrint print = JasperFillManager.fillReport(report, parametros, conexion);
			// Mostrar el informe en JasperViewer
			JasperViewer.viewReport(print, false);
			// Para exportarlo a pdf
			JasperExportManager.exportReportToPdfFile(print, nombreInforme + ".pdf");
			// Abrir el fichero PDF generado
			File path = new File(nombreInforme + ".pdf");
			Desktop.getDesktop().open(path);

		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}