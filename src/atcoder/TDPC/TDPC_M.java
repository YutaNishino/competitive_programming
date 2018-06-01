package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TDPC_M {
    int h, r;
    boolean[][] gss;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new TDPC_M().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        r = sc.nextInt();
        gss = new boolean[r][r];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                gss[i][j] = sc.nextInt() == 1;
            }
        }
        solve();
    }

    void solve() {
        long[][][] dp = new long[1 << r][r][r];
        long[][] matrix = new long[r][r];
        for (int i = 0; i < r; i++) {
            dp[1 << i][i][i] = 1;
        }
        for (int i = 0; i < (1 << r); i++) {
            for (int start = 0; start < r; start++) {
                for (int current = 0; current < r; current++) {
                    for (int next = 0; next < r; next++) {
                        if (((i >> next) & 1) > 0 || !gss[current][next]) {
                            continue;
                        }
                        dp[i | 1 << next][start][next] += dp[i][start][current];
                        dp[i | 1 << next][start][next] %= MOD;
                    }
                    matrix[current][start] += dp[i][start][current];
                    matrix[current][start] %= MOD;
                }
            }
        }
        long[] vector = new long[r];
        vector[0] = 1;
        System.out.println(modMultiplyVector(modPowMatrix(matrix, h - 1, MOD), vector, MOD)[0]);
    }

    long[][] modPowMatrix(long[][] matrix, int n, int mod) {
        long[][] ret = matrix.clone();
        while (n > 0) {
            if (n % 2 == 1) {
                ret = modMultiplyMatrix(ret, matrix, mod);
            }
            n /= 2;
            matrix = modMultiplyMatrix(matrix, matrix, mod);
        }
        return ret;
    }

    long[][] modMultiplyMatrix(long[][] a, long[][] b, int mod) {
        long[][] ret = new long[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    ret[i][j] = (ret[i][j] + a[i][k] * b[k][j]) % mod;
                }
            }
        }
        return ret;
    }

    long[] modMultiplyVector(long[][] matrix, long[] vector, int mod) {
        long[] ret = new long[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                ret[i] = (ret[i] + matrix[i][j] * vector[j]) % mod;
            }
        }
        return ret;
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
