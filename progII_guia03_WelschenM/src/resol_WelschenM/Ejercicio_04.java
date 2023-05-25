package resol_WelschenM;

import java.util.Scanner;

public class Ejercicio_04 {
	private static Scanner input = new Scanner(System.in);
	public void contraseña() {
		System.out.println("Ingrese la contraseña");
		String pass =input.next();
		char[] letra =pass.toCharArray();
		int mayus=0, minus=0, num=0,i=0;
		boolean bandera= true;
		if(pass.length()<8) {
			System.out.println("La contraseña ingresada no es segura, debe ingresar al menos 8 letras y/o numeros");	
		}else {
			while(bandera && mayus<2 && minus<3 && num<2) {
				if(letra[i]>64 && letra[i] <91|| letra[i]==165) {
					mayus++;
					i++;
					}else if(letra[i]>96 && letra[i]<123|| letra[i]==164) {
						minus++;
						i++;
					}else if(letra[i]=='_') {
						i++;
					}else {
						System.out.println("La contraseña ingresada no es segura");
						bandera=false;
					}	
		}
			if (bandera) {
				System.out.println("La contraseña ingresada es segura");
			}
		}	
		}
	}