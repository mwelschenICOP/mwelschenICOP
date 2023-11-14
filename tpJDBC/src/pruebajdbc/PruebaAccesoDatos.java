package pruebajdbc;

public class PruebaAccesoDatos {

	public static void main(String[] args) {
		AccesoDatos AD = new AccesoDatos();
		AD.abrirConexion();
		AD.obtenerDatosTabla();
		AD.mostrarDatosCoches();
		AD.modificar("BA-3333", 5000);
		AD.borrar("MA");
		AD.insertar("AA-0005", "Ford", 4500, "1A");
		AD.insertar2("X25", "Jose", 54);
		AD.cerrarConexion();
	}
}
