package ConexionBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Logica.Mesa;
import Logica.Reserva;

public class MesaAD {
	AccesoDatos ad = new AccesoDatos();
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	Statement st;
	
	
	public boolean guardarMesas(Mesa mesa, int id) throws SQLException {
		String sql = "INSERT INTO mesa (nromesa, estado, capacidad, consumo, idresto) VALUES (?, ?, ?, ?, ?)";
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setInt(1, mesa.getNroMesa());
			pst.setString(2, mesa.estadoActual());
			pst.setInt(3, mesa.getCapacidad());
			pst.setDouble(4, +mesa.getConsumo());
			pst.setInt(5, id);
			pst.execute();
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString());
			return false;
		}finally {
			ad.cerrarConexion();
		}
	}
	public Mesa buscarMesa(int num) {
		String sql = "SELECT * FROM mesa WHERE nromesa = ?;";
		Mesa mesa = new Mesa();
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setInt(1, num);
			rs = pst.executeQuery();
			while(rs.next()) {
				mesa.setNroMesa(rs.getInt("nromesa"));
				mesa.setEstado(rs.getString("estado"));
				mesa.setCapacidad(rs.getInt("capacidad"));
				mesa.setConsumo(rs.getDouble("consumo"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			  return null;
		}finally {
			ad.cerrarConexion();
		}return mesa;
	}
	public ArrayList<Mesa> buscarMesaidResto(int idresto) {
		ArrayList<Mesa> m = new ArrayList<Mesa>();
		String sql = "SELECT * FROM mesa WHERE idresto = ?";
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setInt(1, idresto);
			rs = pst.executeQuery();
			while(rs.next()) {
				 Mesa mesa = new Mesa();
				mesa.setNroMesa(rs.getInt("nromesa"));
				mesa.setEstado(rs.getString("estado"));
				mesa.setCapacidad(rs.getInt("capacidad"));
				mesa.setConsumo(rs.getDouble("consumo"));
				m.add(mesa);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			  return null;
		}finally {
			ad.cerrarConexion();
		}return m;
	}
	public void cambiarEstado(String string, int nMesa) {
	String sql = "UPDATE mesa SET estado = ? WHERE nromesa = ?";
		
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setString(1, string);
			pst.setInt(2, nMesa);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ad.cerrarConexion();
		}	
	}
	public void cambiarEstado(double cons, int nMesa, String estado) {
		String sql = "UPDATE mesa SET estado = ?, consumo = ? WHERE nromesa = ?";
		
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setString(1, estado);
			pst.setDouble(2, cons);
			pst.setInt(3, nMesa);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ad.cerrarConexion();
		}
		
	}
	public void cambiarEstado(int mesa, String estadoActual) {
		String sql = "UPDATE mesa SET estado = ? WHERE nromesa = ?";
		try {
			con = ad.abrirConexion();
			pst = con.prepareStatement(sql);
			pst.setString(1, estadoActual);
			pst.setInt(2, mesa);
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			ad.cerrarConexion();
		}
	}
}
