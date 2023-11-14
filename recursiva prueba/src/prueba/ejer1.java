package prueba;

import java.util.Scanner;


public class ejer1 {
	private static Scanner input = new Scanner(System.in);
	
	public static int funcionRecursiva(int r[], int n) {
	
		//int[]vector=r;
		if (n==0) {
		
			//int x=1;
		//	int y=0;
			r[0]=0;
			r[1]=1;
			r[2]=0;
		
			 return r[n] ;
		
		}else {
			int x= r[1];
			int y= r[2];
			r[2]=x+y;
			r[1]=r[2]+y;
			r[0]=n;
			//y=x-a;
			//x=a-y;
			System.out.println(r[0] +" "+ r[1] +" " + r[2]);
			
			return r[n] + funcionRecursiva(r, n-1) ;
		}
		
	}
	
	
	public static void main(String[] args) {
		ejer1 funcion=new ejer1();
		int[]r = new int[3];
		
		funcion.funcionRecursiva(r,2);

	}
}
