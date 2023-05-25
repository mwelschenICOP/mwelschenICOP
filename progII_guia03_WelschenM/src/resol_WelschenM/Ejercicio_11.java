package resol_WelschenM;

import java.util.Scanner;

public class Ejercicio_11 {
	private static Scanner input = new Scanner(System.in);
	public static void operar() {
		System.out.println("Ingrese un entero");
		System.out.println("Ingrese un numero con decimales");
		System.out.println("Ingrese una letra");
		int N=input.nextInt();
		double A=input.nextDouble();
		char C=input.next().charAt(0);
		int valorC=C;
		System.out.println("Variable N = "+N);
		System.out.println("Variable A = "+A);
		System.out.println("Variable C = "+C);
		System.out.println(N+" + "+A+" = "+(N+A));
		System.out.println(A+" - "+N+" = "+(A-N));
		System.out.println("Valor numérico del carácter A = "+valorC);
		System.out.println("Suma = "+(N+A+C));
	}
}
