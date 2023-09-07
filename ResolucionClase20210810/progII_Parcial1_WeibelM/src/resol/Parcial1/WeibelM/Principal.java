package resol.Parcial1.WeibelM;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Domicilio domOS = new Domicilio("San Martin", 1550, "Sur", 3018);
		Domicilio domEmp = new Domicilio("Guemes", 222, "Centro", 3000);
		
		ObraSocial miOS = new ObraSocial(domOS);
		
		miOS.setRazonSocial("Inmaculada CARE");
		

		
		Empleado empl1 = new Empleado("Martinez", "Pedro","12345678", "01/03/1987", Genero.M, domEmp, "02/01/2021", Cargo.AgenteAfiliador);
		
		miOS.emplear(empl1);
		
	
		miOS.mostrar();
		
	}

}
