package resol_WelschenM;

import java.util.Scanner;

public class Ejercicio_12 {
	private static Scanner input = new Scanner(System.in);
	public static void ejercicioA() {
		System.out.println("Ingrese un entero");
		int A=input.nextInt();
		String resultado = (A%2 == 0) ? A+" es par" : A+" es impar";

		System.out.println(resultado);
	}
	public static void ejercicioB() {
		System.out.println("Ingrese otro entero");
		int C=input.nextInt();
		String signo = (C>=0) ? "positivo" : "negativo";
		String parImpar = (C%2 == 0) ? "par" : "impar";
		String multiplo5 = (C%5 == 0) ? "es múltiplo de 5" : "no es múltiplo de 5";
		String multiplo10 = (C%10 == 0) ? "es múltiplo de 10" : "no es múltiplo de 10";
		String mayorMenor = (C>100) ? "es mayor que 100" : (C < 100) ? "es menor que 100" : "es igual a 100";

		System.out.println(C+" es " + signo + ", " + parImpar + ", " + multiplo5 + ", " + multiplo10 + " y " + mayorMenor + ".");
	}
}
