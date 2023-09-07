package tpCoches;

import java.sql.*;

public class AccesoDatos {
	Connection con;
	Statement st;
	ResultSet rs;
	public void abrirConexion() {
	try {
	String userName="postgres";
	String password="Baraku44??";
	String

	url="jdbc:postgresql://localhost/DatosCoches?useTimezone=true&serverTimezone=UTC";
	con = DriverManager.getConnection(url, userName, password);
	System.out.println("Conexión a la BD");
	}
	catch (Exception e) {
	System.out.println("Error en conexión ");
	System.out.println(e.getMessage());
	}
	}
}
