package atcoder.ABC070;

import java.util.Scanner;
import java.util.Stack;

public class ABC070C {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] ts = new long[n];
        for (int i = 0; i < n; i++) {
            ts[i] = sc.nextLong();
        }
        for(int i = 1; i < n; i++) {
            ts[i] = LCM(ts[i - 1], ts[i]);
        }
        System.out.println(ts[n - 1]);
    }

    static long LCM(long a, long b) {
        return a / GCD(a, b) * b;
    }

    static long GCD(long a, long b) {
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(a, b));
        while(!stack.isEmpty()) {
            Pair p = stack.pop();
            if (p.b == 0) {
                return p.a;
            }
            stack.push(new Pair(p.b, p.a % p.b));
        }
        return -1;
    }

    static class Pair {
        long a;
        long b;
        Pair(long a, long b) {
            this.a = a;
            this.b = b;
        }
    }
}
