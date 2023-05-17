package practica;
import java.util.Scanner;
public class TPJuego {
	private static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		int Y = 1;
		int X = 100;
		int INCOG = (int)(Math.random()*(Y-X+1)+X);
		int chances1 = 10, chances2 = 10, apuesta = 50, saldo1 = 1000, saldo2 = 1000, pozo = 0;
		boolean turno = true;
		do {
			if (turno) {
				System.out.println("Turno del jugador 1 \n");
				System.out.println("Si desea doblar la apuesta ingrese 1, de lo contrario ingrese 2 \n");
				int doblar = input.nextInt();
				if (doblar == 1) {
					if (saldo1>=(apuesta*2))
						apuesta*=2;
					else {
						System.out.println("Saldo insuficiente para doblar apuesta \n");
					}
				}
				pozo+=apuesta;
				turno=!turno;
				saldo1-=apuesta;
				chances1--;
				System.out.println("Elija un numero entero del 1 al 100 \n");
				int num = input.nextInt();
				if (num<INCOG) {
					System.out.println("El numero que debe adivinar es mayor a "+num+"\n");
				}else if (num>INCOG) {
					System.out.println("El numero que debe adivinar es menor a "+num+"\n");
				}else {
					System.out.println("El jugador 1 es GANADOR! el numero incognita era el "+num+"\n");
					System.out.println("Ha ganado un total de $"+pozo+"\n");
					System.out.println("El saldo final es de $"+(pozo+saldo1));
					break;
				}
				System.out.println("El saldo restante del jugador 1 es: "+saldo1+"\n");
				System.out.println("Las chances restantes del jugador 1 son: "+chances1+"\n");
				System.out.println("El ultimo valor de apuesta es: "+apuesta+"\n");
				if (saldo1<=0 || chances1==0 || saldo1<apuesta) {
					System.out.println("El jugador 2 es GANADOR!\n");
					System.out.println("Ha ganado un total de $"+pozo+"\n");
					System.out.println("El saldo final es de $"+(pozo+saldo2));
				}else if(saldo2<apuesta){
					System.out.println("El jugador 1 es GANADOR!\n");
					System.out.println("Ha ganado un total de $"+pozo+"\n");
					System.out.println("El saldo final es de $"+(pozo+saldo1));
				}
			} else {
				System.out.println("Turno del jugador 2 \n");
				System.out.println("Si desea doblar la apuesta ingrese 1, de lo contrario ingrese 2 \n");
				int doblar = input.nextInt();
				if (doblar == 1) {
					if (saldo2>=(apuesta*2))
						apuesta*=2;
					else {
						System.out.println("Saldo insuficiente para doblar apuesta \n");
					}
				}
				pozo+=apuesta;
				turno=!turno;
				saldo2-=apuesta;
				chances2--;
				System.out.println("Elija un numero entero del 1 al 100 \n");
				int num = input.nextInt();
				if (num<INCOG) {
					System.out.println("El numero que debe adivinar es mayor a "+num+"\n");
				}else if (num>INCOG) {
					System.out.println("El numero que debe adivinar es menor a "+num+"\n");
				}else {
					System.out.println("El jugador 2 es GANADOR! el numero incognita era el "+num+"\n");
					System.out.println("Ha ganado un total de $"+pozo+"\n");
					System.out.println("El saldo final es de $"+(pozo+saldo2));
					break;
				}
				System.out.println("El saldo restante del jugador 2 es: "+saldo2+"\n");
				System.out.println("Las chances restantes del jugador 2 son: "+chances2+"\n");
				System.out.println("El ultimo valor de apuesta es: "+apuesta+"\n");
				if (saldo2<=0 || chances2==0 || saldo2<apuesta) {
					System.out.println("El jugador 1 es GANADOR!\n");
					System.out.println("Ha ganado un total de $"+pozo+"\n");
					System.out.println("El saldo final es de $"+(pozo+saldo1));
				}else if(saldo1<apuesta){
					System.out.println("El jugador 2 es GANADOR!\n");
					System.out.println("Ha ganado un total de $"+pozo+"\n");
					System.out.println("El saldo final es de $"+(pozo+saldo2));
				}
			}
		} while (saldo1>=apuesta && saldo2>=apuesta && chances1>0 && chances2 >0 && saldo1>0 && saldo2>0);
	}
}
