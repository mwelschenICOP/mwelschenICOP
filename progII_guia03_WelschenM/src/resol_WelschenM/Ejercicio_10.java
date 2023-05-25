package resol_WelschenM;

import java.util.Scanner;

public class Ejercicio_10 {
	private static Scanner input = new Scanner(System.in);
	public static void llenarVector(int[] vector) {
		System.out.println("Ingrese los 9 numeros del isbn, para calcular su digito verificador");
		for (int i=0 ; i<9; i++) {
		int isbn= input.nextInt();
		vector[i]=isbn;
		}
	}
	public void calcVerificador(int[] vector) {
		int acumulador=0;
		for (int i=0 ; i<9; i++) {
			acumulador+=(vector[i]*(i+1));
		}
		int verificador=acumulador%11;
		System.out.println("ISBN "+vector[0]+"-"+vector[1]+vector[2]+vector[3]+"-"+vector[4]+vector[5]+vector[6]+vector[7]+vector[8]+"-"+verificador);
}
}
/*B. Verifica si los siguientes son correctos:
ISBN 0-7645-2641-3 --> Es correcto  
ISBN 2-8254-4280-6 --> Es incorrecto  
ISBN 2-1234-5680-2 --> Es correcto  
*/