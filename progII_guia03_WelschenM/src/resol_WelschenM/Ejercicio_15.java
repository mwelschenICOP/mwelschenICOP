package resol_WelschenM;
import java.util.Scanner;
public class Ejercicio_15 {
	Scanner input = new Scanner(System.in);
	public void mostrarVocales() {
		char[] vocales= {'A','E','I','O','U'};
		String cadena= ""; 
		int posicion;
		do {
			System.out.print("Ingrese una posición del array (-1 para terminar): ");
			posicion = input.nextInt();
			if (posicion >= 0 && posicion < vocales.length) {
				cadena += vocales[posicion];
			} else if (posicion != -1) {
				System.out.println("La posición ingresada es incorrecta");
			}
		} while (posicion != -1);
		System.out.println("Cadena resultante: "+cadena);
	}
}