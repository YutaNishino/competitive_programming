package atcoder.ABC086;

import java.util.Scanner;

public class ABC086B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = Integer.valueOf(String.valueOf(a) + String.valueOf(b));
        int d = Double.valueOf(Math.sqrt(c)).intValue();
        if (d * d == c) System.out.println("Yes");
        else System.out.println("No");
    }
}
