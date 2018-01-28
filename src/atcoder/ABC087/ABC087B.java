package atcoder.ABC087;

import java.util.Scanner;

public class ABC087B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int x = sc.nextInt();
        int count = 0;
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                int sumab = 500 * i + 100 * j;
                int remain = x - sumab;
                if (remain < 0) continue;
                if (remain <= 50 * c) count++;
            }
        }
        System.out.println(count);
    }
}
