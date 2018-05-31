package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TDPC_G {
    char[] cs;
    long k;

    public static void main(String args[]) {
        new TDPC_G().run();
    }

    void run() {
        FastReader sc = new FastReader();
        cs = sc.next().toCharArray();
        k = sc.nextLong();
        solve();
    }

    void solve() {
        int[][] nextPositions = new int[cs.length + 1][26];
        for (int i = 0; i <= cs.length; i++) {
            Arrays.fill(nextPositions[i], -1);
        }
        long[] dp = new long[cs.length + 1];
        dp[cs.length] = 1;
        for (int i = cs.length - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                nextPositions[i][j] = nextPositions[i + 1][j];
            }
            dp[i] = 1;
            for (int j = 0; j < 26; j++) {
                int to = nextPositions[i][j];
                if (to != -1) {
                    dp[i] += dp[to];
                    dp[i] = Math.min(dp[i], (long)1e18 + 1);
                }
            }
            nextPositions[i][cs[i] - 'a'] = i;
        }
        dp[0]--;
        if (dp[0] < k) {
            System.out.println("Eel");
            return;
        }
        StringBuilder ans = new StringBuilder();
        int position = 0;
        while (k > 0) {
            long index = 0;
            for (int j = 0; j < 26; j++) {
                if (nextPositions[position][j] == -1) {
                    continue;
                }
                if (index + dp[nextPositions[position][j]] < k) {
                    k -= dp[nextPositions[position][j]];
                } else {
                    ans.append((char)(j + 'a'));
                    k--;
                    position = nextPositions[position][j] + 1;
                    break;
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
