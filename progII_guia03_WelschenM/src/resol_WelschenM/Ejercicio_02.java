package resol_WelschenM;
import java.util.Scanner;
public class Ejercicio_02 {
	private static Scanner input = new Scanner(System.in);
	double prom = 0;
	public void llenarVector(int[] vector) {
		int n=vector.length;
		System.out.println("Ingrese los "+n+" enteros que quiere promediar");
		for (int i=0 ; i<n; i++) {
		int entero= input.nextInt();
		vector[i]=entero;
		}
	}
	public void calcPromedio(int[] vector) {
		int n=vector.length;
		int i=0;
		double num=0;
		while (i<n) {
			num+=vector[i];
			i++;
		}
		prom=num/n;
		System.out.println("El promedio es "+prom);
		for(int j=0; j<n;j++) {
			if (vector[j]>(prom)) {
				System.out.println(vector[j]+" es mayor al promedio");
		}
		}
	}
}
