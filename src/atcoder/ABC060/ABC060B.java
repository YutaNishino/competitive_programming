package atcoder.ABC060;

import java.util.Scanner;

public class ABC060B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        for (int i = 0; i < b; i++)
            if (a * (i + 1) % b == c) {
                System.out.println("YES");
                return;
            }
        System.out.println("NO");
    }
}
