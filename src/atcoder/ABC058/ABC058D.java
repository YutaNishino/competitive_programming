package atcoder.ABC058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC058D {
    int n, m;
    int[] xs, ys;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new ABC058D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        xs = new int[n];
        ys = new int[m];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            ys[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        long xSum = 0;
        for (int i = 0; i < n; i++) {
            xSum += (long)(2 * i - n + 1) * xs[i];
            xSum %= MOD;
        }
        long ySum = 0;
        for (int i = 0; i < m; i++) {
            ySum += (long)(2 * i - m + 1) * ys[i];
            ySum %= MOD;
        }

        System.out.println(xSum * ySum % MOD);
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
