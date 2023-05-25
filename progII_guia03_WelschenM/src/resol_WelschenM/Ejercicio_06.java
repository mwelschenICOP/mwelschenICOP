package resol_WelschenM;
import java.util.Scanner;
public class Ejercicio_06 {
	private static Scanner input = new Scanner(System.in);
	public void primo(){
		System.out.println("Ingrese un numero entero");
		int num=input.nextInt();
		double resto =1;
		int i=2;
		while(i<num && resto!=0) {
			if ((num%i)!=0) {
				resto=(num%i);
				i++;
			}else {
				System.out.println(num+" no es primo");
				resto=(num%i);
			}
		}if (resto!=0){
			System.out.println(num+" es primo");
		}
	}
}