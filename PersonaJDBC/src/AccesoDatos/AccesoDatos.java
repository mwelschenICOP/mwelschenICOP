package AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccesoDatos {
	Connection con;
	Statement st;
	ResultSet rs;
	public void abrirConexion() {
		try {
			String userName="postgres";
			String password="Baraku44??";
			String url="jdbc:postgresql://localhost/tpJDBC?useTimezone=true&serverTimezone=UTC";
			con = DriverManager.getConnection(url, userName, password);
			System.out.println("Conexión a la BD");
		}
		catch (Exception e) {
			System.out.println("Error en conexión ");
			System.out.println(e.getMessage());
		}
	}
	public void cerrarConexion() {
		try {
			con.close();
			System.out.println("Conexión cerrada");
		}
		catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}

	}
}
