package resol_WelschenM;
public class Ejercicio_05 {
		public static int calcFibonacci(int x){
		if(x<3) {
			return 1;
		}else return calcFibonacci(x-2)+calcFibonacci(x-1);
		}
}
