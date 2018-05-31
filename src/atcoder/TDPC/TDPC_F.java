package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPC_F {
    int n, k;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new TDPC_F().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        solve();
    }

    void solve() {
        long[][] dp = new long[n + 1][2];
        dp[0][0] = dp[0][1] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            if (i >= k) {
                dp[i][1] = (dp[i][1] - dp[i - k][0] + MOD) % MOD;
            }
        }
        for (int i = 0; i <= n; i++) {
            System.out.print(dp[i][0] + " ");
        }
        System.out.println();
        for (int i = 0; i <= n; i++) {
            System.out.print(dp[i][1] + " ");
        }
        System.out.println();
        System.out.println(dp[n][1]);
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
