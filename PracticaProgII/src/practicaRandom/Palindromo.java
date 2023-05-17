package practicaRandom;
import java.util.Scanner;
public class Palindromo {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
	
		System.out.println("ingrese una palabra");
		String palabra = input.next();
		int n0=0;
		int n=palabra.length()-1;
		boolean pali=true;
		do {
			if (palabra.charAt(n0)==palabra.charAt(n)) {
				n0++;
				n--;
			} else {
				System.out.println("No es palindromo");
				pali=false;
			}		
		} while (n0<=n&&pali);
		if (pali) {
			System.out.println("es palindormo");
		}
	}
}
