package Controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Modelo.Direccion;

public class DireccionCtrl {
	AccesoDatos ad = new AccesoDatos();
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	int id;

	
	
	public boolean RegistrarDireccion(Direccion dir) throws SQLException {
		String sql = "INSERT INTO direccion (calle, numero) VALUES (?,?)";
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setString(1, dir.getCalle());
			pst.setInt(2, dir.getNumero());
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
