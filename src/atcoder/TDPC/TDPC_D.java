package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPC_D {
    int n;
    long d;

    public static void main(String args[]) {
        new TDPC_D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        d = sc.nextLong();
        solve();
    }

    void solve() {
        int two = 0;
        int three = 0;
        int five = 0;
        while (d % 2 == 0) {
            two++;
            d /= 2;
        }
        while (d % 3 == 0) {
            three++;
            d /= 3;
        }
        while (d % 5 == 0) {
            five++;
            d /= 5;
        }
        if (d > 1) {
            System.out.println(0.0);
            return;
        }
        double[][][] dp = new double[201][101][101];
        double[][][] next = new double[201][101][101];
        dp[0][0][0] = 1;
        int jMax = 0;
        int kMax = 0;
        int lMax = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= jMax; j++) {
                for (int k = 0; k <= kMax; k++) {
                    for (int l = 0; l <= lMax; l++) {
                        next[j][k][l] = 0;
                    }
                }
            }
            for (int j = 0; j <= jMax; j++) {
                for (int k = 0; k <= kMax; k++) {
                    for (int l = 0; l <= lMax; l++) {
                        next[j + 1][k][l] += dp[j][k][l] / 6;
                        next[j][k + 1][l] += dp[j][k][l] / 6;
                        next[j + 2][k][l] += dp[j][k][l] / 6;
                        next[j][k][l + 1] += dp[j][k][l] / 6;
                        next[j + 1][k + 1][l] += dp[j][k][l] / 6;
                        next[j][k][l] += dp[j][k][l] / 6;
                    }
                }
            }
            jMax += 2;
            kMax += 1;
            lMax += 1;
            double[][][] temp = next;
            next = dp;
            dp = temp;
        }
        double ans = 0;
        for (int j = two; j <= jMax; j++) {
            for (int k = three; k <= kMax; k++) {
                for (int l = five; l <= lMax; l++) {
                    ans += dp[j][k][l];
                }
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
