package EjVet;
import java.util.Scanner; 
public class Principal {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		
		Veterinaria veterinaria = new Veterinaria();
		Canino canino = new Canino(0, "pedro", "1/1/1", sexo.Hembra, false, null, "Ovejero", Pelaje.corto, "negro", 20, false, true);
		veterinaria.agregarMascota(canino);
		Ofidios ofidio = new Ofidios(0, "juank", "2/2/2", sexo.Macho, false, null, Especie.boa, 99, true, false, false);
		veterinaria.agregarMascota(ofidio);
		int eleccion;
		do {
	System.out.println("Elija la opcion deseada:\n"
				+ "1. desparacitar\n"
				+ "2. Cargar mascota\n"
				+ "3. Mostrar veterinaria\n"
				+ "4. Mostrar mascota \n"
				+ "5. eliminar mascota\n"
				+ "6. mostrar caninos \n"
				+ "7. mostrar ofidios \n"
				+ "8. vacunar\n"
				+ "9. \n"
				+ "0 para salir");

	 eleccion=input.nextInt();
	switch(eleccion) {
	case 1:
		canino.desparacitar();
		break;
	case 2:
		veterinaria.agregarMascota();
		break;
	case 3:
		veterinaria.mostrarVeterinaria();
		break;
	case 4:
		veterinaria.mostrarMascotas();
		break;
	case 5:
		veterinaria.eliminarMascota();
		break;
	case 6:
		canino.mostrar();
		break;
	case 7:
		ofidio.mostrar();
		break;
	case 8:
		canino.vacunar();
		break;
	default:
		System.out.println("Saliendo del sistema...");
	}
	}while(eleccion!=0);
	}
}
