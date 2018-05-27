package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPC_A {
    int n;
    int[] ps;

    public static void main(String args[]) {
        new TDPC_A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        ps = new int[n];
        for (int i = 0; i < n; i++) {
            ps[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        boolean[][] dp = new boolean[101][10101];
        dp[0][0] = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 10000; j++) {
                dp[i + 1][j] |= dp[i][j];
                dp[i + 1][j + ps[i]] |= dp[i][j];
            }
        }
        int count = 0;
        for (int j = 0; j < dp[0].length; j++) {
            if (dp[n][j]) {
                count++;
            }
        }
        System.out.println(count);
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
