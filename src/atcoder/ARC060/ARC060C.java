package atcoder.ARC060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC060C {
    int n, a;
    int[] xs;

    public static void main(String args[]) {
        new ARC060C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        a = sc.nextInt();
        xs = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        long[][][] dp = new long[n + 1][n + 1][50 * n + 1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k < 50 * n + 1; k++) {
                    if (j >= 1 && xs[i - 1] <= k) {
                        dp[i][j][k] = dp[i - 1][j][k] + dp[i - 1][j - 1][k - xs[i - 1]];
                    } else {
                        dp[i][j][k] = dp[i - 1][j][k];
                    }
                }
            }
        }
        long ans = 0;
        for (int j = 1; j <= n; j++) {
            ans += dp[n][j][j * a];
        }
        System.out.println(ans);
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
