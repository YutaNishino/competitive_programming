package atcoder.ABC020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC020D {
    int n, k;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new ABC020D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        solve();
    }

    void solve() {
        long[] gcds = new long[k + 1];
        long sum = 0;
        for (int i = 1; i <= k; i++) {
            gcds[i] = gcd(i, k);
        }
        long m = n / k;
        for (int i = 1; i <= k; i++) {
            sum += (m * i + m  * (m - 1) / 2* k) * k / gcds[i];
            sum %= MOD;
        }
        int remain = n % k;
        for (int i = n; i > n - remain; i--) {
            sum += i / gcds[i - n + remain] * k % MOD;
            sum %= MOD;
        }
        System.out.println(sum);
    }

    long lcm(int a, int b) {
        return (long)a / gcd(a, b) * b;
    }

    int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements())
            {
                try
                {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt()
        {
            return Integer.parseInt(next());
        }

        long nextLong()
        {
            return Long.parseLong(next());
        }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try
            {
                str = br.readLine();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            return str;
        }
    }
}
