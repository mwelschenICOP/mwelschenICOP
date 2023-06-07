package Principal;

import java.util.Scanner;
import Entidades.*;

public class Principal {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int num;
		do {
		System.out.println("Elija opcion:\n"
				+ "1. Ejercicio 1\n"
				+ "2. Ejercicio 2\n"
				+ "3. Ejercicio 3\n"
				+ "4. Ejercicio 4\n");
		num = input.nextInt();
		switch (num) {
		case 0:
			System.out.println("Salir del sistema");
			break;
		case 1:
			System.out.println("Ingrese el isbn");
			String isbn=input.next();
			System.out.println("Ingrese el titulo");
			String titulo=input.next();
			System.out.println("Ingrese el autor");
			String autor=input.next();
			System.out.println("Ingrese el numero de paginas");
			int numPag=input.nextInt();
			
			Libro unLibro= new Libro(isbn, titulo, autor, numPag);
			unLibro.setIsbn(isbn);
			unLibro.setTitulo(titulo);
			unLibro.setAutor(autor);
			unLibro.setNumeroPaginas(numPag);
			System.out.println("El ISBN es: "+unLibro.getIsbn());
			System.out.println("El titulo del libro es: "+unLibro.getTitulo());
			System.out.println("El autor es: "+unLibro.getAutor());
			System.out.println("El numero de paginas es: "+unLibro.getNumeroPaginas());	
			break;
		case 2:
			System.out.println("Ingrese el radio");
			double r=input.nextDouble();
			Circunferencia unaCircunferencia = new Circunferencia(r);
			unaCircunferencia.crearCircunferencia(r);
			unaCircunferencia.area();
			unaCircunferencia.perimetro();
			
		}
		}while(num!=0);
	}
}
