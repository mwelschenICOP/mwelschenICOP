package palabrasValidas;

import java.util.Scanner;

public class palabras {
	private static Scanner input = new Scanner(System.in);

	public static void main(String[] args) {
		char letra;

		System.out.println("Ingrese palabra");
		letra = input.next().charAt(0);
			switch (letra) {
			case '_': {
				System.out.println("Es valido");
				break;
			}
			case '$': {
				System.out.println("Es valido");
				break;
			
			}
			default:
				if (letra>64 && letra <91 || letra>96 && letra<123) {
					System.out.println("Es valido");
					
					}
				else {
					System.out.println("No es valido");
				}
	}
	}
}
	

