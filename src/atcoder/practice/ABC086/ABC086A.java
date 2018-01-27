package atcoder.practice.ABC086;

import java.util.Scanner;

public class ABC086A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = a * b;
        if (c % 2 == 0) System.out.println("Even");
        else System.out.println("Odd");
    }
}
