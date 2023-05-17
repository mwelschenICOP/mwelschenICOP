package resol_WelschenM;
import java.util.Scanner;
public class Ejercicio_03 {
	private static Scanner input = new Scanner(System.in);
	public int Invertir(int unNro) {
		System.out.println("ingrese un numero");
	int num = input.nextInt();
	int resto;
	int result=0;
	
	do {
		resto=num%10;
		num =(int) Math.floor(num/10);
		result=result*10+resto;
		System.out.println("resultad: "+resto);
	}
	while(num>0);
	System.out.println("resultado es: "+result);
		
	return unNro;
 }
}
