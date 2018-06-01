package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPC_L {
    int n;
    int[][] fss;

    public static void main(String args[]) {
        new TDPC_L().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        fss = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fss[i][j] = sc.nextInt();
            }
        }
        solve();
    }

    void solve() {
        long[][] sumss = new long[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                sumss[i][j] = sumss[i][j + 1] + fss[i][j];
            }
        }
        long[] maxes = new long[n];
        long[][] dp = new long[n][n];
        for (int i = 1; i < n; i++) {
            long[] newMaxes = new long[n];
            for (int j = 0; j <= i; j++) {
                dp[i][j] = maxes[j] + sumss[i][j] * 2;
                if (j == 0) {
                    newMaxes[j] = dp[i][j];
                } else {
                    newMaxes[j] = Math.max(newMaxes[j - 1], dp[i][j]);
                }
            }
            maxes = newMaxes;
            if (i < n - 1) {
                maxes[i + 1] = maxes[i];
            }
        }
        long max = 0;
        for (int j = 0; j < n; j++) {
            max = Math.max(max, dp[n - 1][j]);
        }
        System.out.println(max);
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
