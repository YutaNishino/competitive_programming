package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPC_E {
    int d;
    int MOD = 1000000007;
    char[] cs;

    public static void main(String args[]) {
        new TDPC_E().run();
    }

    void run() {
        FastReader sc = new FastReader();
        d = sc.nextInt();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        int[] nDigits = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            nDigits[i] = Character.getNumericValue(cs[i]);
        }
        long[][][] dp = new long[10001][2][100];
        dp[0][0][0] = 1;
        for (int i = 0; i < nDigits.length; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < d; k++) {
                    int limit = j == 1 ? 9 : nDigits[i];
                    for (int l = 0; l <= limit; l++) {
                        int jNum = j;
                        if (l < limit) {
                            jNum = 1;
                        }
                        int kNum = (k + l) % d;
                        dp[i + 1][jNum][kNum] += dp[i][j][k];
                        dp[i + 1][jNum][kNum] %= MOD;
                    }
                }
            }
        }
        long ans = 0;
        for (int j = 0; j < 2; j++) {
            ans += dp[nDigits.length][j][0];
            ans %= MOD;
        }
        ans += MOD - 1;
        ans %= MOD;
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
