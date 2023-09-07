package ParcialAseguradora;

import java.util.Scanner;

public class Principal {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int eleccion;
		Aseguradora aseguradora = new Aseguradora("La Tercera Seguros", null,null,null);
		Taxi taxi = new Taxi("Ford", "Ka",2016,25645,"Chasiss","Azul",114,"ABC123",6458412);
		aseguradora.agregarTaxi(taxi);
		Autobus autobus = new Autobus("Mercedes", "f200",2018,2545645,"Chasis7","Rojo",12134,"ACN423",65);
		aseguradora.agregarAutobus(autobus);
		Cliente cliente = new Cliente("Juan", "Fernandez", Genero.Femenino, 44444444, "juancito@gmail.com", "Piedras 6091", 470485);
		aseguradora.agregarCliente(cliente);
		Poliza poliza = new Poliza(14,"10/5/95","10/5/96",12,FormaPago.DebitoAutomatico,511555555,false,45612,taxi,cliente,null,TipoCobertura.Parcial);
		aseguradora.agregarPoliza(poliza);		
		
		do {
	System.out.println("Elija la opcion deseada:\n"
				+ "1. OK Registrar un cliente\n"
				+ "2. OK Listar todos los clientes\n"
				+ "3. OK Buscar un cliente por documento\n"
				+ "4. OK Registrar vehiculo \n"
				+ "5. OK Listar todos los vehiculos\n"
				+ "6. OK Listar vehiculos por tipo \n"
				+ "7. ok Listar vehiculos por cobertura \n"
				+ "8. OK Buscar vehiculo por matricula\n"
				+ "9. OK Registrar una poliza\n"
				+ "10. OKPagar cuota\n"
				+ "11. OK Listar poliza por tipo de cobertura\n"
				+ "12. Buscar una poliza, mostrar la informacion y lista de cuotas\n"
				+ "13. Ver datos estadisticos\n"
				+ "0 para salir");

	 eleccion=input.nextInt();
	switch(eleccion) {
	case 1:
		aseguradora.agregarCliente();
		break;
	case 2:
		aseguradora.mostrarCliente();
		break;
	case 3:
		aseguradora.buscarClienteXDNIMostrar();
		break;
	case 4:
		aseguradora.agregarVehiculo();
		break;
	case 5:
		aseguradora.mostrarVehiculo();
		break;
	case 6:
		aseguradora.mostrarVehiculoTipo();
		break;
	case 7:
		aseguradora.buscarVehiculoXCobertura();
		break;
	case 8:
		aseguradora.buscarVehiculoXMatriculaYMostrar();
		break;
	case 9:
		aseguradora.agregarPoliza();
		break;
	case 10:
		aseguradora.pagarCuota();
		break;
	case 11:
		aseguradora.listarPolizaXCobertura();
		break;
	case 12:
		aseguradora.mostrarPoliza();
		break;
	case 13:
		aseguradora.estadisticas();
		break;
	default:
		System.out.println("Saliendo del sistema...");
	}
	}while(eleccion!=0);
	}
}
