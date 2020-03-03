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
import javax.swing.table.DefaultTableModel;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

// TODO: Auto-generated Javadoc
/**
 * The Class UtilidadesDB.
 */
public class UtilidadesDB {

	/**
	 * Connect data base.
	 *
	 * @return the connection
	 * @throws ClassNotFoundException the class not found exception
	 * @throws SQLException the SQL exception
	 */
	public static Connection connectDataBase() throws ClassNotFoundException, SQLException {

		Connection resultado = null;
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/di4db? autoReconnect=true&useSSL=false";
		String loginBD = "root";
		String passwordBD = "Studium2018;";

		// Cargar el Driver
		Class.forName(driver);

		// Establecer la conexión con la base de datos
		resultado = DriverManager.getConnection(url, loginBD, passwordBD);

		return resultado;
	}

	// Este método genera un Select a partir de los elementos básicos si se quiere
	/**
	 * Generate select.
	 *
	 * @param elements the elements
	 * @param fromTable the from table
	 * @param where the where
	 * @return the string
	 */
	// ordenar, debe introducirse a continuación del Where.
	public static String generateSelect(String elements, String fromTable, String where) {

		String resultado = "SELECT " + elements + " FROM " + fromTable + " WHERE " + where + ";";
		return resultado;
	}

	/**
	 * Take date.
	 *
	 * @return the string
	 */
	// Método para recoger la fecha actual.
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
	 * Formato date SQL.
	 *
	 * @param s the s
	 * @return the string
	 */
	public static String formatoDateSQL(String s) {
		String resultado = s;
		String[] listaResultado = resultado.split("/");
		resultado = listaResultado[2] + "/" + listaResultado[1] + "/" + listaResultado[0];
		return resultado;
	}
	
	/**
	 * Formato date SQL.
	 *
	 * @param s the s
	 * @param splitter the splitter
	 * @return the string
	 */
	public static String formatoDateSQL(String s, String splitter) {
		String resultado = s;
		String[] listaResultado = resultado.split(splitter);
		resultado = listaResultado[2] + splitter + listaResultado[1] + splitter + listaResultado[0];
		return resultado;
	}

	/**
	 * Disconnect gestion.
	 *
	 * @param c the c
	 */
	// Método para cerrar una conexión.
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
	 * Execute select.
	 *
	 * @param sentencia the sentencia
	 * @param c the c
	 * @return the result set
	 */
	// Método para ejecutar una sentencia Select.
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
	 * Execute IDA.
	 *
	 * @param sentencia the sentencia
	 * @param c the c
	 * @throws SQLException the SQL exception
	 */
	// Método para ejecutar un CUD de CRUD.
	public static void executeIDA(String sentencia, Connection c) throws SQLException {
		Statement statement = null;
		// Preparar el statement

		statement = c.createStatement();
		statement.executeUpdate(sentencia);

		disconnectGestion(c);
	}

	/**
	 * Execute IDA.
	 *
	 * @param sentencia the sentencia
	 * @param c the c
	 * @param cerrarCon the cerrar con
	 * @throws SQLException the SQL exception
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

	// Este método rellena un ComboBox utilizando una sentencia SQL guardada en un
	// resultSet.
	// En la lista de Integers se indican qué elementos de la sentencia se van a
	/**
	 * Fill combo box RS.
	 *
	 * @param rs the rs
	 * @param c the c
	 * @param lista the lista
	 */
	// coger y en qué orden se colocarán.
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

	// Este método une varios de los métodos anteriores para hacerlo todo en una
	/**
	 * Complex fill CB.
	 *
	 * @param sentencia the sentencia
	 * @param cmb the cmb
	 * @param lista the lista
	 */
	// sola línea de código.
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
	 * Complexfill J table.
	 *
	 * @param sentencia the sentencia
	 * @param columnas the columnas
	 * @param tabla the tabla
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
	 * Complexfill J table.
	 *
	 * @param sentencia the sentencia
	 * @param columnas the columnas
	 * @param tabla the tabla
	 * @param columnaFecha the columna fecha
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

	// Para hacerlo más sencillo La sentencia debe devolver un solo String con los
	/**
	 * Complex fill J list.
	 *
	 * @param sentencia the sentencia
	 * @param lista the lista
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
	 * Genera informe.
	 *
	 * @param nombreInforme the nombre informe
	 * @param parametros the parametros
	 */
	public static void generaInforme(String nombreInforme, HashMap<String, Object> parametros) {
		try {
			// Compilar el informe generando fichero jasper
			JasperCompileManager.compileReportToFile(nombreInforme + ".jrxml");
			System.out.println("Fichero" + nombreInforme + ".jasper generado CORRECTAMENTE!");
			// Objeto para guardar parámetros necesarios para el informe
			
			// Cargar el informe compilado
			JasperReport report = (JasperReport) JRLoader.loadObjectFromFile(nombreInforme + ".jasper");
			// Conectar a la base de datos para sacar la información
			Class.forName("com.mysql.jdbc.Driver");
			String servidor = "jdbc:mysql://localhost:3306/di4db?useSSL=false";
			String usuarioDB = "root";
			String passwordDB = "Studium2018;";
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