package atcoder.ABC085;

import java.util.Scanner;

public class ABC085C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int y = sc.nextInt();
        for (int i = 0; i <= n; i++) {
            for (int j = n - i; j >= 0; j--) {
                int x = i * 10000 + j * 5000 + (n - i - j) * 1000;
                if (x == y) {
                    System.out.printf("%d %d %d\n", i, j, n - i - j);
                    return;
                }
            }
        }
        System.out.println("-1 -1 -1");
    }
}
