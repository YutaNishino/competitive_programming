package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPC_C {
    int k, n;
    int[] rs;

    public static void main(String args[]) {
        new TDPC_C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        k = sc.nextInt();
        n = (int)pow(2, k);
        rs = new int[n];
        for (int i = 0; i < n; i++) {
            rs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        double[][] dp = new double[1024][11];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < k; j++) {
            for (int i = 0; i < n; i++) {
                double win = 0;
                int l = (i >> j << j) ^ (1 << j) ;
                int lEnd = l + (1 << j);
                for (; l < lEnd; l++) {
                    win += prob(rs[i], rs[l]) * dp[l][j];
                }
                dp[i][j + 1] = win * dp[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(dp[i][k]);
        }
    }

    double prob(int a, int b) {
        return 1.0 / (1 + Math.pow(10, ((double)b - a) / 400));
    }

    long pow(long x, int n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * x;
            }
            x = x * x;
            n >>= 1;
        }
        return ans;
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
