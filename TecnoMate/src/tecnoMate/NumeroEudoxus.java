package tecnoMate;

import java.util.Scanner;

public class NumeroEudoxus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int x = 1;
            int y = 0;
            for (int j = 1; j <= n; j++) {
            	
                int y1 = y;
                y = x + y1;
                x = y + y1;
                
            }

            System.out.println(x + " " + y);
        }
    }
}