package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPC_I {
    char[] cs;
    int[][] dp;

    public static void main(String args[]) {
        new TDPC_I().run();
    }

    void run() {
        FastReader sc = new FastReader();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        dp = new int[cs.length + 1][cs.length + 1];
        for (int w = 0; w <= cs.length; w++) {
            for (int l = 0; l + w <= cs.length; l++) {
                for (int i = l; i <= l + w; i++) {
                    dp[l][l + w] = Math.max(dp[l][l + w], dp[l][i] + dp[i][l + w]);
                }
                if (dp[l][l + w] != w) {
                    continue;
                }
                for (int d = 0; d <= 3; d++) {
                    if (l - d < 0 || l + w + 3 - d > cs.length) {
                        continue;
                    }
                    char[] iwi = new char[3];
                    for (int e = 0; e < d; e++) {
                        iwi[e] = cs[l - d + e];
                    }
                    for (int e = d; e < 3; e++) {
                        iwi[e] = cs[l + w - d + e];
                    }
                    if (iwi[0] == 'i' && iwi[1] == 'w' && iwi[2] == 'i') {
                        dp[l - d][l + w + 3 - d] = dp[l][l + w] + 3;
                    }
                }
            }
        }
        System.out.println(dp[0][cs.length] / 3);
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
