package resol_WelschenM;

import java.util.Scanner;

public class Ejercicio_16 {
	private static Scanner input = new Scanner(System.in);
	public static void datosAlumnos(double[] notas, String[] nombres) {
		for (int i = 0; i < notas.length; i++) {
			System.out.println("Ingrese el nombre del alumno");
			nombres[i] = input.nextLine();
			boolean notaValida = false;
			while (!notaValida) {
				System.out.println("Ingrese la nota del alumno");
				double nota = input.nextDouble();
				input.nextLine();
				if (nota >= 0 && nota <= 10) {
					notas[i] = nota;
					notaValida = true;
				} else {
					System.out.println("La nota ingresada no es válida. Debe ser entre 0 y 10");
				}
			}
		}
	}
	public static void resultadosNotas(double[] notas, String[] resultados) {
		for (int i = 0; i < notas.length; i++) {
			if (notas[i] >= 0 && notas[i] <= 4.99) {
				resultados[i] = "Suspenso";
			} else if (notas[i] >= 5 && notas[i] <= 6.99) {
				resultados[i] = "Bien";
			} else if (notas[i] >= 7 && notas[i] <= 8.99) {
				resultados[i] = "Notable";
			} else if (notas[i] >= 9 && notas[i] <= 10) {
				resultados[i] = "Sobresaliente";
			}
		}
	}
	public static void mostrar(double[] notas, String[] nombres, String[] resultados) {
		System.out.println("Alumnos\t\tNota\tResultado");
		for (int i = 0; i < notas.length; i++) {
			System.out.println(nombres[i] + "\t\t" + notas[i] + "\t" + resultados[i]);
		}
	}
}