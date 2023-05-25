package resol_WelschenM;

import java.util.Scanner;

public class Ejercicio_13 {
	private static Scanner input = new Scanner(System.in);
	public static int funcionRecursiva(int N) {
		if (N==1) 
			return N;
		else return N + funcionRecursiva(N-1);
	}
	
	public static void funcionIterativa(int B) {
		System.out.println("Ingrese otro entero");
		int N=input.nextInt();
		int suma=0;
		  for (int i = 1; i <= N; i++) {
	            suma += i;
	        }
		  System.out.println("La suma de los primeros "+N+" elementos es: "+suma);
	}
}
//A priori me resultó mas facil entender la iterativa, pero una vez comprendida la funcion recursiva, se hace muy práctica para algunos casos.