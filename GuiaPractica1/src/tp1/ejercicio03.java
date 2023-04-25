package tp1;

import java.util.Scanner;

public class ejercicio03 {

	private static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {

		System.out.println("Ingrese una frase");
		String frase = input.nextLine();
		System.out.println("La frase en mayúsculas es: " + frase.toUpperCase());
		System.out.println("La frase en minúsculas es: " + frase.toLowerCase());
	}

}
