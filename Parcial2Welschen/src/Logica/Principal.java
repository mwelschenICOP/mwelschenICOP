package Logica;

import java.util.Scanner;
import Control.Control;
import ConexionBD.MesaAD;
import ConexionBD.ReservaAD;

public class Principal {
	//private Control control;
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Control control= new Control();
		control.mostrarResto();
		int nr=input.nextInt();
		Resto r = control.setearResto(nr);
		Resto resto = new Resto(r.getNombre(),r.getCalle(),r.getCiudad(),r.getId());
		MesaAD mesaad = new MesaAD();
		resto.setListaMesas(mesaad.buscarMesaidResto(resto.getId()));
    	ReservaAD reservaad = new ReservaAD(mesaad);
		resto.setListaReservas(reservaad.traerReservas(resto.getId()));
		int eleccion;
		
		/*Resto resto = new Resto("Paucke", "General Lopez 2545", "Santa Fe");
		resto.nuevaMesa(2, 4);
		resto.nuevaMesa(4, 4);
		resto.nuevaMesa(6, 3);
	
		// (Quitar comentarios a esta parte, y comentar desde la linea 10 hasta la 13 para probar con el resto "Los primos") 
		 
		Resto resto = new Resto("Los Primos", "San Martín 1601", "Santa Fe");
		resto.nuevaMesa(8, 5);
		resto.nuevaMesa(4, 10);
		resto.nuevaMesa(6, 6);
		*/
		 
		do {
			System.out.println("Elija la opcion deseada:\n"
						+ "1. Agregar Mesas (una o varias)\n"
						+ "2. Ver todas las mesas\n"
						+ "3. Informacion de resto por fecha\n"
						+ "4. Ver mesas por estado\n"
						+ "5. Ver mesas por fecha y estado\n"
						+ "6. Ver capacidad y estados\n"
						+ "7. Ver capacidad y estados por fecha\n"
						+ "8. Ocupar mesa\n"
						+ "9. Liberar mesa\n"
						+ "10. Reservar una mesa para hoy\n"
						+ "11. Reservar una mesa con fecha futura\n"
						+ "12. Eliminar una mesa\n"
						+ "13. Reservar una mesa con fecha y cantidad de comensales\n"
						+ "14. Mostrar 3 mesas con mayor consumo acumulado\n"
						+ "0 para salir");

			 eleccion=input.nextInt();
			switch(eleccion) {
			case 1:
				resto.nuevaMesa();
				break;
			case 2:
				resto.mostrarMesas();
				break;
			case 3:
				System.out.println("Ingrese 1 para consultar fecha actual o 2 para elegir fecha:");
				int op = input.nextInt();
				if (op==1) {
					resto.mostrarInfo();
				}else {
					System.out.println("Ingrese fecha:(dd/mm/aaaa)");
					input.nextLine();
					String fecha = input.nextLine();
					resto.mostrarInfo(fecha);
				}
				break;
			case 4:
				System.out.println("Ingrese 1 para consultar mesas libres, 2 para reservadas o 3 para ocupadas:");
				int o = input.nextInt();
				if (o==1) {
					resto.mostrarMesas("Liberada");
				}else if (o==2) {
					resto.mostrarMesas("Reservada");
				}else {
					resto.mostrarMesas("Ocupada");
				}
				break;
			case 5:
				input.nextLine();
				System.out.println("Ingrese fecha:(dd/mm/aaaa)");
				String f = input.nextLine();
				System.out.println("Ingrese 1 para consultar mesas libres, 2 para reservadas:");
				int o1= input.nextInt();
				
				if (o1==1) {
					resto.mostrarMesas("Liberada", f);
				
				}else {
					resto.mostrarMesas("Reservada", f);
				}
				break;
			case 6:
				resto.mostrarCapacidad();
				break;
			case 7:
				input.nextLine();
				System.out.println("Ingrese fecha:(dd/mm/aaaa)");
				String fe = input.nextLine();
				resto.mostrarCapacidad(fe);
				break;
			case 8:
				resto.altaMesa();
				break;
			case 9:
				resto.bajaMesa();
				break;
			case 10:
				resto.reservarMesa();
				break;
			case 11:
				System.out.println("Ingrese fecha:(dd/mm/aaaa)");
				input.nextLine();
				String fecha = input.nextLine();
				resto.mostrarInfo(fecha);
				resto.reservarMesa(fecha);
				break;
			case 12:
				resto.eliminarMesa();
				break;
			case 13:
				System.out.println("Ingrese fecha:(dd/mm/aaaa)");
				input.nextLine();
				String fech = input.nextLine();
				System.out.println("Ingrese la cantidad de comensales");
				int cap=input.nextInt();
				if(resto.getId()==1 && cap>6){
			    	System.out.println("No tenemos mesas para mas de 6 personas, recomendamos reservar 2 mesas o mas");
			    }else if(resto.getId()==2 && cap>8){
			    	System.out.println("No tenemos mesas para mas de 8 personas, recomendamos reservar 2 mesas o mas");	
			    }else {
				resto.mostrarInfo(fech, cap);
				resto.reservarMesa(fech, cap);
			    }
				break;
			case 14:
				resto.top3ConsumoMesas();
				break;
			case 15:
				resto.mostrarMesasXEstado();
				break;
			default:
				System.out.println("Saliendo del sistema...");
			}
			}while(eleccion!=0);	
	}
}
