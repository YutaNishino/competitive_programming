package atcoder.indeed_now_final_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class indeed_now_final_A_C {
    int n, m;

    public static void main(String args[]) {
        new indeed_now_final_A_C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        long[][][] dp = new long[101][101][101];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();
            dp[l][j][k] = Math.max(dp[l][j][k], sc.nextInt());
        }
        for (int i = 0; i <= 100; i++) {
            for (int j = 0; j <= 100; j++) {
                for (int k = 0; k <= 100; k++) {
                    if (i > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j][k]);
                    }
                    if (j > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j - 1][k]);
                    }
                    if (k > 0) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i][j][k - 1]);
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            System.out.println(dp[sc.nextInt()][sc.nextInt()][sc.nextInt()]);
        }
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
