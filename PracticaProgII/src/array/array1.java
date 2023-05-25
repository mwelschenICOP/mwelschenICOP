package array;
import java.util.Scanner;
public class array1 {
	private static Scanner input = new Scanner(System.in);
	public static void mostrarVector(String[] vector) {
		for (int i=0 ; i<10; i++) {
			System.out.println("["+vector[i]+"],");
		}
	}
	public static void llenarVector(String[] vector) {
		for (int i=0 ; i<10; i++) {
		String nombre= input.next();
		vector[i]=nombre;
	}
	}
	public static void main(String[] args) {
		String[] Alumnos = new String[10];
		System.out.println("ingrese los nombres de cada alumno por separado");
		llenarVector(Alumnos);
		mostrarVector(Alumnos);
	}
}