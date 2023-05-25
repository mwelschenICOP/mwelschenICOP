package Principal;
import java.util.Scanner;

import Entidades.Libro;

public class Principal {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		System.out.println("Ingrese el isbn");
		String isbn=input.next();
		System.out.println("Ingrese el titulo");
		String titulo=input.next();
		System.out.println("Ingrese el autor");
		String autor=input.next();
		System.out.println("Ingrese el numero de paginas");
		int numPag = input.nextInt();
		
		Libro unLibro= new Libro(isbn, titulo, autor, numPag);
		unLibro.setIsbn(isbn);
		unLibro.setTitulo(titulo);
		unLibro.setAutor(autor);
		unLibro.setNumeroPaginas(numPag);
		System.out.println("El ISBN es: "+unLibro.getIsbn());
		System.out.println("El titulo del libro es: "+unLibro.getTitulo());
		System.out.println("El autor es: "+unLibro.getAutor());
		System.out.println("El numero de paginas es: "+unLibro.getNumeroPaginas());	
	}
}
