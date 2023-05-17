package practica;
import java.util.Scanner;
import java.util.Random;
public class ordenar {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		Random numero = new Random();
		// Generar nombre
		System.out.println("Ingrese su nombre");
		String nombre = input.nextLine();
		// Generar edad
		System.out.println("Ingrese su edad");
		int edad = input.nextInt();
		//Generar numero aleatorio
		int num1 = numero.nextInt(1000);
		int num2 = numero.nextInt(1000);
		int num3 = numero.nextInt(1000);
		int num4 = numero.nextInt(1000);
		int orden1, orden2, orden3, orden4;
		System.out.println("Ingrese '1' para ordenar de forma descendente o '2' para ordenar ascendentemente");
		int elegir=input.nextInt();
		if (elegir==2){
			if (num1 < num2) {
				orden1 = num1;
				orden2 = num2;
			} 		else {orden1 = num2;
			orden2 = num1;
			}
			if (num3 < orden1) {
				orden3 = orden2;
				orden2 = orden1;
				orden1 = num3;
			} 		else if (num3 < orden2) {
				orden3 = orden2;
				orden2 = num3;
			} 				else {
				orden3 = num3;
			}
			if (num4 < orden1) {
				orden4 = orden3;
				orden3 = orden2;
				orden2 = orden1;
				orden1 = num4;
			} 		else if (num4 < orden2) {
				orden4 = orden3;
				orden3 = orden2;
				orden2 = num4;	
			} 				else if (num4 < orden3) {
				orden4 = orden3;
				orden3 = num4;		
			} 
			else {
				orden4 = num4;
			}

			//mostrar resultados
			System.out.println("Nombre: " + nombre);
			System.out.println("Edad: " + edad);
			System.out.println("Orden ascendente: ");
			System.out.println("orden 1 " + orden1 );
			System.out.println("orden 2 " + orden2 );
			System.out.println("orden 3 " + orden3 );
			System.out.println("orden 4 " + orden4 );
		}else if(elegir==1){
			if (num1 > num2) {
				orden1 = num1;
				orden2 = num2;
			} 		else {orden1 = num2;
			orden2 = num1;
			}
			if (num3 > orden1) {
				orden3 = orden2;
				orden2 = orden1;
				orden1 = num3;
			} 		else if (num3 > orden2) {
				orden3 = orden2;
				orden2 = num3;
			} 				else {
				orden3 = num3;
			}
			if (num4 > orden1) {
				orden4 = orden3;
				orden3 = orden2;
				orden2 = orden1;
				orden1 = num4;
			} 		else if (num4 > orden2) {
				orden4 = orden3;
				orden3 = orden2;
				orden2 = num4;	
			} 				else if (num4 > orden3) {
				orden4 = orden3;
				orden3 = num4;		
			} 
			else {
				orden4 = num4;
			}

			//mostrar resultados
			System.out.println("Nombre: " + nombre);
			System.out.println("Edad: " + edad);
			System.out.println("Orden descendente: ");
			System.out.println("orden 1 " + orden1 );
			System.out.println("orden 2 " + orden2 );
			System.out.println("orden 3 " + orden3 );
			System.out.println("orden 4 " + orden4 );
		}else {
			System.out.println("El numero ingresado no es valido");
		}
	}
}