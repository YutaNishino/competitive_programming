package atcoder.ABC040;

import java.util.Scanner;

public class ABC040B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            int candidate = (n - i * (n / i)) + Math.abs(i - n / i);
            if (ans > candidate) ans = candidate;
        }
        System.out.println(ans);
    }
}
