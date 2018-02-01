package atcoder.ABC070;

import java.util.Scanner;

public class ABC070A {
    static String[] n;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.next().split("");
        boolean result = solve();
        if (result) System.out.println("Yes");
        else System.out.println("No");
    }

    static boolean solve() {
        int i = 0;
        while (true) {
            if (i == n.length - i - 1) break;
            if (!n[i].equals(n[n.length - i - 1])) return false;
            i++;
        }
        return true;
    }
}
