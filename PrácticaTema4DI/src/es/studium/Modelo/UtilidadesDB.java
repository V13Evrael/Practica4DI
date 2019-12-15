package es.studium.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

public class UtilidadesDB {

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
	// ordenar, debe introducirse a continuación del Where.
	public static String generateSelect(String elements, String fromTable, String where) {

		String resultado = "SELECT " + elements + " FROM " + fromTable + " WHERE " + where + ";";
		return resultado;
	}

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

	public static String formatoDateSQL(String s) {
		String resultado = s;
		String[] listaResultado = resultado.split("/");
		resultado = listaResultado[2] + "/" + listaResultado[1] + "/" + listaResultado[0];
		return resultado;
	}

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

	// Método para ejecutar un CUD de CRUD.
	public static void executeIDA(String sentencia, Connection c) throws SQLException {
		Statement statement = null;
		// Preparar el statement

		statement = c.createStatement();
		statement.executeUpdate(sentencia);

		disconnectGestion(c);
	}
	
	public static void executeIDA(String sentencia, Connection c, boolean cerrarCon) throws SQLException {
		
		if (cerrarCon) {
			executeIDA(sentencia, c);
		}
		else {
			Statement statement = null;
			// Preparar el statement

			statement = c.createStatement();
			statement.executeUpdate(sentencia);
		}	
	}

	// Este método rellena un ComboBox utilizando una sentencia SQL guardada en un
	// resultSet.
	// En la lista de Integers se indican qué elementos de la sentencia se van a
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

	// Para hacerlo más sencillo La sentencia debe devolver un solo String con los
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
}