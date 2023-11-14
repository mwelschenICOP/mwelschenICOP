package pruebajdbc;
import java.sql.*;

public class AccesoDatos {
	Connection con;
	Statement st;
	ResultSet rs;
	public void abrirConexion() {
		try {
			String userName="postgres";
			String password="Baraku44??";
			String url="jdbc:postgresql://localhost/DatosCoches?useTimezone=true&serverTimezone=UTC";
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
	public void obtenerDatosTabla() {
		try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM Coches ORDER BY precio DESC");
			System.out.println("Tabla abierta");
		} catch (SQLException e) {
			System.out.println("Error al Abrir tabla ");
		}
	}
	public void mostrarDatosCoches() {
		try {
			while (rs.next()) {
				String strMat = rs.getString("Matricula");
				String strMarca = rs.getString("Marca");
				int intPrecio = rs.getInt("Precio");
				System.out.println(strMat + ", " + strMarca + ", " + intPrecio);
			}
		} catch (Exception e) {
			System.out.println("Error al visualizar datos");
		}
	}
	//Método para modificar la tabla Coches pasando la matrícula del
	//coche que se quiere modificar y el nuevo precio. Las cadenas en la
	//condición es necesario ponerlas entre comillas simples.
	public void modificar(String m, int p)
	{
		try {
			Statement s2=con.createStatement();
			s2.executeUpdate("UPDATE Coches SET Precio="+ p +
					" WHERE Matricula like '" + m + "%'");
			System.out.println("Elemento modificado correctamente");
		}catch (SQLException e)
		{
			System.out.println("Error al modificar");
		}
	}
	//Método para borrar el coche cuya matricula se pasa como argumento
	public void borrar(String m)
	{
		try{
			Statement s2=con.createStatement();
			s2.executeUpdate(

					"DELETE FROM Coches WHERE Matricula like '"+m+"%'");

			System.out.println("Elemento Borrado");
		}catch(SQLException e)
		{
			System.out.println("Error al Borrar");
		}
	}
	//Método que permite insertar un nuevo registro en la tabla Coches,
	//pasándole como argumento la matrícula, marca, precio del coche y
	//dni del propietario
	public void insertar(String m, String mar, int p, String d){
		try{

			Statement s1 = con.createStatement();
			s1.executeUpdate(

					"INSERT INTO Coches (Matricula,Marca,Precio,DNI) VALUES ('"
							+ m + "', '" + mar + "'," + p + ",'" + d + "')");

			System.out.println("Elemento insertado");
		}
		catch(SQLException e)
		{
			System.out.println("Error al insertar ");
		}
	}
	//Método para insertar un registro en la tabla Propietarios. Los
	//argumentos del método son el DNI, nombre y edad.
	public void insertar2(String dni, String n, int ed) {
		try {
			PreparedStatement ps = con.prepareStatement(

					"insert into Propietarios values (?,?,?) ");

			ps.setString(1, dni);
			ps.setString(2, n);
			ps.setInt(3, ed);
			//En este caso, el método executeUpdate devuelve la cantidad de
			//elementos insertados.
			if (ps.executeUpdate()!=1)
				throw new Exception("Error en la Inserción");

		}catch (Exception e) {
			System.out.println("Error al Insertar ");
		}
	}
}