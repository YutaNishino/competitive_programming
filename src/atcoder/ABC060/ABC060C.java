package atcoder.ABC060;

import java.util.Scanner;

public class ABC060C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        long ans = t;
        int start = sc.nextInt();
        for (int i = 1; i < n; i++) {
            int ti = sc.nextInt();
            if (start + t > ti)
                ans += ti - start;
            else
                ans += t;
            start = ti;
        }
        System.out.println(ans);
    }
}
