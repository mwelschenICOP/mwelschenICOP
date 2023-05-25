package resol_WelschenM;

import java.util.Scanner;

public class Ejercicio_07 {
	private static Scanner input = new Scanner(System.in);
	public void cadena() {
		String frase;
		System.out.println("Ingrese una frase");
		frase=input.nextLine().trim();
		int palabras=1;
		for(int i=0;i<frase.length();i++) {
			if (frase.charAt(i)==' '  && frase.charAt(i+1)!=' ') {
				palabras++;
			}
		}System.out.println("La frase ingresada contiene "+palabras+" palabras");
	}
}