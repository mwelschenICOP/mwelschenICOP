package resol_WelschenM;

import java.util.Scanner;

public class Principal {

	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		int num;
		do {
		System.out.println("Elija opcion:\n"
				+ "1. Ejercicio 01\n"
				+ "2. Ejercicio 02\n"
				+ "3. Ejercicio 03\n"
				+ "4. Ejercicio 04\n"
				+ "5. Ejercicio 05\n"
				+ "6. Ejercicio 06\n"
				+ "7. Ejercicio 07\n"
				+ "8. Ejercicio 08\n"
				+ "9. Ejercicio 09\n"
				+ "10. Ejercicio 10\n"
				+ "11. Ejercicio 11\n"
				+ "12. Ejercicio 12\n"
				+ "13. Ejercicio 13\n"
				+ "14. Ejercicio 14\n"
				+ "15. Ejercicio 15\n"
				+ "16. Ejercicio 16\n"
				+ "0 para salir");
		num = input.nextInt();
		switch (num) {
		case 0:
			System.out.println("Salir del sistema");
			break;
		case 1:
			System.out.println("Ingresó la opcion 1");
			Ejercicio_01 miEjercicio= new Ejercicio_01();
			miEjercicio.Ejercicio_01();
			break;
		case 2:
			System.out.println("Ingresó la opcion 2");
			break;
		case 3:
			System.out.println("Ingresó la opcion 3");
			Ejercicio_03 capicua=new Ejercicio_03();
			capicua.Invertir(num);
			break;
		case 4:
			System.out.println("Ingresó la opcion 4");
			break;
		case 5:
			System.out.println("Ingresó la opcion 5");
			break;
		case 6:
			System.out.println("Ingresó la opcion 6");
			break;
		case 7:
			System.out.println("Ingresó la opcion 7");
			break;
		case 8:
			System.out.println("Ingresó la opcion 8");
			break;
		case 9:
			System.out.println("Ingresó la opcion 9");
			break;
		case 10:
			System.out.println("Ingresó la opcion 10");
			break;
		case 11:
			System.out.println("Ingresó la opcion 11");
			break;
		case 12:
			System.out.println("Ingresó la opcion 12");
			break;
		case 13:
			System.out.println("Ingresó la opcion 13");
			break;
		case 14:
			System.out.println("Ingresó la opcion 14");
			break;
		case 15:
			System.out.println("Ingresó la opcion 15");
			break;
		case 16:
			System.out.println("Ingresó la opcion 16");
			break;		
		default:
			System.out.println("Ingresó una opcion incorrecta");
			break;
		}
		}while(num!=0);
	}
}
