package ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Logica.Resto;

public class RestoAD {
	AccesoDatos ad = new AccesoDatos();
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public ArrayList<Resto> traerResto() {
		
		ArrayList<Resto> restaurant = new ArrayList<Resto>();
		 String sql = "SELECT * FROM Resto";

		  try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
		    while (rs.next()) {
		      Resto resto = new Resto();
		      resto.setId(rs.getInt("id"));
		      resto.setNombre(rs.getString("nombre"));
		      resto.setCalle(rs.getString("calle"));
		      resto.setCiudad(rs.getString("ciudad"));

		      restaurant.add(resto);
		    }
		  } catch (SQLException e) {
		    e.printStackTrace();
		  } finally {
		    ad.cerrarConexion();
		  }
		  return restaurant;
		}
	
}

