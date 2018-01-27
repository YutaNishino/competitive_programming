package atcoder.practice.ABC086;

import java.util.Scanner;

public class ABC086C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            int tNext = sc.nextInt();
            int xNext = sc.nextInt();
            int yNext = sc.nextInt();
            int time = tNext - t;
            int length = Math.abs(xNext - x) + Math.abs(yNext - y);
            if (time < length || (time - length) % 2 == 1) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
