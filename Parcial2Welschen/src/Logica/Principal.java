package Logica;


import java.util.Scanner;

public class Principal {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int eleccion;
		Resto resto = new Resto("Paucke", "General Lopez 2545", "Santa Fe");
		resto.nuevaMesa(2, 4);
		resto.nuevaMesa(4, 4);
		resto.nuevaMesa(6, 3);
		/*
		 (Quitar comentarios a esta parte, y comentar desde la linea 10 hasta la 13 para probar con el resto "Los primos") 
		 
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
						+ "8. Dar de alta una mesa\n"
						+ "9. Dar de baja una mesa\n"
						+ "10. Reservar una mesa para hoy\n"
						+ "11. Reservar una mesa con fecha futura\n"
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
					resto.mostrarInfo(resto);
				}else {
					System.out.println("Ingrese fecha:(dd/mm/aaaa)");
					input.nextLine();
					String fecha = input.nextLine();
					resto.mostrarInfo(resto, fecha);
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
					resto.mostrarMesas(resto,"Liberada", f);
				
				}else {
					resto.mostrarMesas(resto,"Reservada", f);
				}
				break;
			case 6:
				resto.mostrarCapacidad(resto);
				break;
			case 7:
				input.nextLine();
				System.out.println("Ingrese fecha:(dd/mm/aaaa)");
				String fe = input.nextLine();
				resto.mostrarCapacidad(resto, fe);
				break;
			case 8:
				resto.altaMesa(resto);
				break;
			case 9:
				resto.bajaMesa(resto);
				break;
			case 10:
				resto.reservarMesa(resto);
				break;
			case 11:
				System.out.println("Ingrese fecha:(dd/mm/aaaa)");
				input.nextLine();
				String fecha = input.nextLine();
				resto.mostrarInfo(resto, fecha);
				
				break;
			default:
				System.out.println("Saliendo del sistema...");
			}
			}while(eleccion!=0);		
	}	
}
