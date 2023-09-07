package resol.Parcial1.WeibelME;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ObraSocial miObraInmaculada = new ObraSocial("Inmaculada Care", "San Martin", 1550, 3000);
		miObraInmaculada.mostrar();
		
		miObraInmaculada.agregarEmpleado();
		//miObraInmaculada.agregarAfiliado();
		miObraInmaculada.agregarLocalidadCobertura(3014, "Angel Gallardo");
		/*miObraInmaculada.agregarAfiliado();
		miObraInmaculada.agregarAfiliado();
		miObraInmaculada.agregarAfiliado();
		*/
		
		miObraInmaculada.mostrar();
		miObraInmaculada.detectarFiliacion();
		
	}

}
