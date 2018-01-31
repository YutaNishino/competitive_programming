package atcoder.ABC023;

import java.util.Scanner;

public class ABC023B {
    static String a = "a";
    static String b = "b";
    static String c = "c";
    static int modCount = 0;
    static int i = 0;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        String[] ss = s.split("");
        int ans = solve(n, ss);
        System.out.println(ans);
    }

    static int solve(int n, String[] ss) {
        if (n == 1 && ss[0].equals(b)) return 0;
        if (n % 2 == 0) return -1;
        if (ss[0].equals(a))
            if (!ss[n - 1 - i].equals(c)) return -1;
        else if (ss[0].equals(b))
            if (!ss[n - 1 - i].equals(b)) return -1;
        else if (ss[0].equals(c))
            if (!ss[n - 1 - i].equals(a)) return -1;
        else return -1;
        i++;
        while (true) {
            if (ss[i - 1].equals(a))
                if (!ss[i].equals(b) || !ss[n - 1 - i].equals(b)) return -1;
            else if (ss[i - 1].equals(b))
                if (!ss[i].equals(c) || !ss[n - 1 - i].equals(a)) return -1;
            else if (ss[i - 1].equals(c))
                if (!ss[i].equals(a) || !ss[n - 1 - i].equals(c)) return -1;
            if (i == n - 1 - i) break;
            i++;
        }
        if (ss[i].equals(b)) return i;
        else return -1;
    }
}
