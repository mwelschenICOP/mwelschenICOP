package resol_WelschenM;
import java.util.Scanner;
public class Principal {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int num;
		do {
		System.out.println("Elija opcion:\n"
				+ "1. Ejercicio 01\n"
				+ "2. Ejercicio 02\n"
				+ "3. Ejercicio 03\n"
				+ "4. Ejercicio 04\n"
				+ "5. Ejercicio 05\n"
				+ "6. Ejercicio 06\n"
				+ "7. Ejercicio 07\n"
				+ "8. Ejercicio 08\n"
				+ "9. Ejercicio 09\n"
				+ "10. Ejercicio 10\n"
				+ "11. Ejercicio 11\n"
				+ "12. Ejercicio 12\n"
				+ "13. Ejercicio 13\n"
				+ "14. Ejercicio 14\n"
				+ "15. Ejercicio 15\n"
				+ "16. Ejercicio 16\n"
				+ "0 para salir");
		num = input.nextInt();
		switch (num) {
		case 0:
			System.out.println("Salir del sistema");
			break;
		case 1:
			System.out.println("Ingresó la opcion 1");
			Ejercicio_01 miEjercicio= new Ejercicio_01();
			miEjercicio.Ejercicio01();
			break;
		case 2:
			System.out.println("Ingresó la opcion 2");
			System.out.println("Ingrese la cantidad de numeros enteros a utilizar");
			int n=input.nextInt();
			int Enteros[] = new int[n];
			Ejercicio_02 promedio= new Ejercicio_02();
			promedio.llenarVector(Enteros);
			promedio.calcPromedio(Enteros);
			break;
		case 3:
			System.out.println("Ingresó la opcion 3");
			Ejercicio_03 capicua=new Ejercicio_03();
			capicua.invertir(num);
			break;
		case 4:
			System.out.println("Ingresó la opcion 4");
			Ejercicio_04 password=new Ejercicio_04();
			password.contraseña();
			break;
		case 5:
			System.out.println("Ingresó la opcion 5");
			System.out.println("Ingrese el n elemento que desea calcular de la serie de Fibonacci");
			int x=input.nextInt();
			Ejercicio_05 fibonacci=new Ejercicio_05();
			System.out.println("El resultado es : "+fibonacci.calcFibonacci(x));
			break;
		case 6:
			System.out.println("Ingresó la opcion 6");
			Ejercicio_06 numPrimo=new Ejercicio_06();
			numPrimo.primo();
			break;
		case 7:
			System.out.println("Ingresó la opcion 7");
			Ejercicio_07 contPalabras=new Ejercicio_07();
			contPalabras.cadena();
			break;
		case 8:
			System.out.println("Ingresó la opcion 8");
			Ejercicio_08 billetes=new Ejercicio_08();
			billetes.cuentaBilletes();
			break;
		case 9:
			System.out.println("Ingresó la opcion 9");
			System.out.println("Ingrese la cantidad de numeros enteros a utilizar");
			int q=input.nextInt();
			int Vector[] = new int[q];
			Ejercicio_09 ordenVector=new Ejercicio_09();
			ordenVector.llenarVector(Vector);
			ordenVector.ordenarVector(Vector);
			ordenVector.mostrarVector(Vector);
			break;
		case 10:
			System.out.println("Ingresó la opcion 10");
			int ISBN[] = new int[9];
			Ejercicio_10 calculoISBN=new Ejercicio_10();
			calculoISBN.llenarVector(ISBN);
			calculoISBN.calcVerificador(ISBN);
			break;
		case 11:
			System.out.println("Ingresó la opcion 11");
			Ejercicio_11 operando=new Ejercicio_11();
			operando.operar();
			break;
		case 12:
			System.out.println("Ingresó la opcion 12");
			Ejercicio_12 operadorCondicional=new Ejercicio_12();
			operadorCondicional.ejercicioA();
			operadorCondicional.ejercicioB();
			break;
		case 13:
			System.out.println("Ingresó la opcion 13");
			Ejercicio_13 funcionesSuma=new Ejercicio_13();
			System.out.println("Ingrese un entero");
			int N=input.nextInt();
			System.out.println("La suma de los "+N+" elementos es: "+funcionesSuma.funcionRecursiva(N));
			funcionesSuma.funcionIterativa(0);
			break;
		case 14:
			System.out.println("Ingresó la opcion 14");
			int[] Numeros = new int[10];
			Ejercicio_14 array=new Ejercicio_14();
			array.llenarVector(Numeros);
			array.mostrarVector(Numeros);
			break;
		case 15:
			System.out.println("Ingresó la opcion 15");
			Ejercicio_15 vocales=new Ejercicio_15();
			vocales.mostrarVocales();
			break;
		case 16:
			System.out.println("Ingresó la opcion 16");
			 double[] notas = new double[10];
		     String[] nombres = new String[10];
		     String[] resultados = new String[10];
		     Ejercicio_16 notasAlumnos=new Ejercicio_16();
		     notasAlumnos.datosAlumnos(notas, nombres);
		     notasAlumnos.resultadosNotas(notas, resultados);
		     notasAlumnos.mostrar(notas, nombres, resultados);
			break;		
		default:
			System.out.println("Ingresó una opcion incorrecta");
			break;
		}
		}while(num!=0);
	}
}
