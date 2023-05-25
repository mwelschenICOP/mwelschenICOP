package resol_WelschenM;
import java.util.Scanner;
public class Ejercicio_09 {
	private static Scanner input = new Scanner(System.in);
	public void llenarVector(int[] vector) {
		int n=vector.length;
		System.out.println("Ingrese los "+n+" enteros que quiere ordenar");
		for (int i=0 ; i<n; i++) {
			int entero= input.nextInt();
			vector[i]=entero;
		}
	}
	public void ordenarVector(int[] vector) {
		int n=vector.length;
		int cambios=0;
		for (boolean ordenado=false; !ordenado;) {
			for (int i=0 ; i<n-1; i++) {
				if (vector[i]>vector[i+1]) {
					int aux=vector[i];
					vector[i]=vector[i+1];
					vector[i+1]=aux;
					cambios++;
				}
			}if (cambios==0) {
				ordenado=true;
			}cambios=0;
		}
	}
	public void mostrarVector(int[] vector) {
		for (int i=0 ; i<vector.length; i++) {
			System.out.println("["+vector[i]+"],");
		}
	}
}