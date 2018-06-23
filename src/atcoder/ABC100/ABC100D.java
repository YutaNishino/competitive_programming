package atcoder.ABC100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC100D {
    int n, m;
    long[] xs, ys, zs;
    long[][] memo;

    public static void main(String args[]) {
        new ABC100A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        xs = new long[n];
        ys = new long[n];
        zs = new long[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextLong();
            ys[i] = sc.nextLong();
            zs[i] = sc.nextLong();
        }
        memo = new long[n + 1][n + 1];
        solve();
    }

    void solve() {
        long INF = 1L << 60;
        long[][][] sum = new long[8][n + 1][n + 1];
        long[][][] msum = new long[8][n + 1][n + 1];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    sum[i][j][k] = -INF;
                    msum[i][j][k] = INF;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j <= n; j++) {
                sum[i][j][0] = 0;
                msum[i][j][0] = 0;
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                sum[0][i][j] = Math.max(sum[0][i - 1][j],
                        sum[0][i - 1][j - 1] + xs[i - 1] + ys[i - 1] + zs[i  - 1]);
                sum[1][i][j] = Math.max(sum[1][i - 1][j],
                        sum[1][i - 1][j - 1] + xs[i - 1] + ys[i - 1] - zs[i  - 1]);
                sum[2][i][j] = Math.max(sum[2][i - 1][j],
                        sum[2][i - 1][j - 1] + xs[i - 1] - ys[i - 1] + zs[i  - 1]);
                sum[3][i][j] = Math.max(sum[3][i - 1][j],
                        sum[3][i - 1][j - 1] + xs[i - 1] - ys[i - 1] - zs[i  - 1]);
                sum[4][i][j] = Math.max(sum[4][i - 1][j],
                        sum[4][i - 1][j - 1] - xs[i - 1] + ys[i - 1] + zs[i  - 1]);
                sum[5][i][j] = Math.max(sum[5][i - 1][j],
                        sum[5][i - 1][j - 1] - xs[i - 1] + ys[i - 1] - zs[i  - 1]);
                sum[6][i][j] = Math.max(sum[6][i - 1][j],
                        sum[6][i - 1][j - 1] - xs[i - 1] - ys[i - 1] + zs[i  - 1]);
                sum[7][i][j] = Math.max(sum[7][i - 1][j],
                        sum[7][i - 1][j - 1] - xs[i - 1] - ys[i - 1] - zs[i  - 1]);
                msum[0][i][j] = Math.min(msum[0][i - 1][j],
                        msum[0][i - 1][j - 1] + xs[i - 1] + ys[i - 1] + zs[i  - 1]);
                msum[1][i][j] = Math.min(msum[1][i - 1][j],
                        msum[1][i - 1][j - 1] + xs[i - 1] + ys[i - 1] - zs[i  - 1]);
                msum[2][i][j] = Math.min(msum[2][i - 1][j],
                        msum[2][i - 1][j - 1] + xs[i - 1] - ys[i - 1] + zs[i  - 1]);
                msum[3][i][j] = Math.min(msum[3][i - 1][j],
                        msum[3][i - 1][j - 1] + xs[i - 1] - ys[i - 1] - zs[i  - 1]);
                msum[4][i][j] = Math.min(msum[4][i - 1][j],
                        msum[4][i - 1][j - 1] - xs[i - 1] + ys[i - 1] + zs[i  - 1]);
                msum[5][i][j] = Math.min(msum[5][i - 1][j],
                        msum[5][i - 1][j - 1] - xs[i - 1] + ys[i - 1] - zs[i  - 1]);
                msum[6][i][j] = Math.min(msum[6][i - 1][j],
                        msum[6][i - 1][j - 1] - xs[i - 1] - ys[i - 1] + zs[i  - 1]);
                msum[7][i][j] = Math.min(msum[7][i - 1][j],
                        msum[7][i - 1][j - 1] - xs[i - 1] - ys[i - 1] - zs[i  - 1]);
            }
        }
        long ans = 0;
        for (int i = m; i <= n; i++) {
            for (int k = 0; k < 8; k++) {
                ans = Math.max(ans, Math.abs(sum[k][i][m]));
                ans = Math.max(ans, Math.abs(msum[k][i][m]));
            }
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
