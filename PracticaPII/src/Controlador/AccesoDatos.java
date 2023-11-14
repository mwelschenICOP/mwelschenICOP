package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class AccesoDatos {
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	public Connection abrirConexion() {
		try {
			String userName="postgres";
			String password="Baraku44??";
			String url="jdbc:postgresql://localhost/pruebaPII?useTimezone=true&serverTimezone=UTC";
			con = DriverManager.getConnection(url, userName, password);
			return con;
		}
		catch (Exception e) {
			System.out.println("Error en conexión ");
			System.out.println(e.getMessage());
		}return null;
		
	}
	public Connection cerrarConexion() {
		try {
			con.close();
		}
		catch (SQLException e) {
			System.out.println("Error al cerrar conexión");
		}return null;

	}
}
