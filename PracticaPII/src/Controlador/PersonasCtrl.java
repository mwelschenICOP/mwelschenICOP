package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import Modelo.Personas;

public class PersonasCtrl {
	AccesoDatos ad = new AccesoDatos();
	Connection con;
	PreparedStatement pst;
	
	
	public boolean RegistrarPersona(Personas per) throws SQLException {
		String sql = "INSERT INTO personas (nombre, iddireccion)  VALUES (?, ?)";
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setString(1, per.getNombre());
			pst.setInt(2, );
			pst.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return false;
		}finally {
			ad.cerrarConexion();
		}
		
	}
}

