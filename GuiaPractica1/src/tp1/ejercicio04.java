package tp1;

import java.util.Scanner;

public class ejercicio04 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		System.out.println("Ingrese la temperatura en grados centígrados");
		double tempC = input.nextInt();
		System.out.println("El equivalente en grados Fahrenheit es: " + (32+(9*tempC/5)));
	}

}
