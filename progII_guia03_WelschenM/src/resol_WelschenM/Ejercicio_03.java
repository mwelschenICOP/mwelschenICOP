package resol_WelschenM;
import java.util.Scanner;
public class Ejercicio_03 {
	private static Scanner input = new Scanner(System.in);
	public int invertir(int unNro) {
		System.out.println("ingrese un numero");
	int num = input.nextInt();
	int inicial = num;
	int resto;
	int result=0;
	do {
		resto=num%10;
		num =(int) Math.floor(num/10);
		result=result*10+resto;
	}
	while(num>0);
	if (inicial==result) {
		System.out.println(inicial +" es capicua");
	}else {
		System.out.println(inicial +" no es capicua");
	}		
	return unNro;
 }
}