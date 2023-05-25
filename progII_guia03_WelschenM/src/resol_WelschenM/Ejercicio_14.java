package resol_WelschenM;

import java.util.Scanner;

public class Ejercicio_14 {
	private static Scanner input = new Scanner(System.in);
	public static void llenarVector(int[] vector) {
		System.out.println("Ingrese los 10 enteros");
		for (int i=0 ; i<10; i++) {
		int num= input.nextInt();
		vector[i]=num;
		}
	}
	public static void mostrarVector(int[] vector) {
		for (int i=0 ; i<10; i++) {
			System.out.println(i+1+" = ["+vector[i]+"],");
		}
	}
}