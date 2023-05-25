package resol_WelschenM;
import java.util.Scanner;
public class Ejercicio_08 {
	private static Scanner input = new Scanner(System.in);
	public void cuentaBilletes() {
		System.out.println("Ingrese el monto");
		int total=input.nextInt();
		int t100,t50,t20,t10,t5,t2,t1,resto=0;
		if(total>99) {
			t100=(int) Math.floor(total/100);
			resto=total%100;
			System.out.println("Cantidad de billetes de $100: -- "+t100+" --");
		}
		if(resto>49){
			t50=(int) Math.floor(resto/50);
			resto=resto%50;
			System.out.println("Cantidad de billetes de $50: -- "+t50+" --");
		}
		if(resto>19){
			t20=(int) Math.floor(resto/20);
			resto=resto%20;
			System.out.println("Cantidad de billetes de $20: -- "+t20+" --");
		}
		if(resto>9){
			t10=(int) Math.floor(resto/10);
			resto=resto%10;
			System.out.println("Cantidad de billetes de $10: -- "+t10+" --");
		}
		if(resto>4){
			t5=(int) Math.floor(resto/5);
			resto=resto%5;
			System.out.println("Cantidad de billetes de $5: -- "+t5+" --");
		}
		if(resto>1){
			t2=(int) Math.floor(resto/2);
			resto=resto%2;
			System.out.println("Cantidad de billetes de $2: -- "+t2+" --");
		}
		if(resto>0){
			t1=(int) Math.floor(resto/1);
			resto=resto%1;
			System.out.println("Cantidad de billetes de $1: -- "+t1+" --");
		}
	}
}
