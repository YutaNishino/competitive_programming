package atcoder.ABC015;

import java.util.Scanner;

public class ABC015A {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        if (a.length() < b.length()) System.out.println(b);
        else System.out.println(a);
    }
}
