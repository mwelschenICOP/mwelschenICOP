package Logica;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int eleccion;
		Mesa mesa = new Mesa();
		ArrayList<Mesa> listMesa = new ArrayList<Mesa>();
		Resto resto = new Resto("Paucke", "General Lopez 2545", "Santa Fe", listMesa);
		do {
			System.out.println("Elija la opcion deseada:\n"
						+ "1. Agregar Mesas\n"
						+ "2. \n"
						+ "3. \n"
						+ "4. \n"
						+ "5. \n"
						+ "6. \n"
						+ "7. \n"
					
						+ "0 para salir");

			 eleccion=input.nextInt();
			switch(eleccion) {
			case 1:
				mesa.nuevaMesa();
				break;
			case 2:
				resto.listarMesas();
				break;
			case 3:
				
				break;
			case 4:
				
				break;
			case 5:
				
				break;
			case 6:
				
				break;
			case 7:
				
				break;
			case 8:
				
				break;
			case 9:
				
				break;
			case 10:
				
				break;
			case 11:
				
				break;
			case 12:
				
				break;
			case 13:
				
				break;
			default:
				System.out.println("Saliendo del sistema...");
			}
			}while(eleccion!=0);		
	}	
}
