package atcoder.indeed_now_final_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class indeed_now_final_B_C {
    int n;
    char[] ss;
    int[] cs;

    public static void main(String args[]) {
        new indeed_now_final_B_C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        ss = sc.next().toCharArray();
        cs = new int[n];
        for (int i = 0; i < n; i++) {
            cs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        boolean[][] palTable = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            int l = i;
            int r = i;
            while (l >= 0 && r < n && ss[l] == ss[r]) {
                palTable[l][r] = true;
                l--;
                r++;
            }
            l = i;
            r = i + 1;
            while (l >= 0 && r < n && ss[l] == ss[r]) {
                palTable[l][r] = true;
                l--;
                r++;
            }
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = 1 << 30;
        }
        for (int r = 0; r < n; r++) {
            for (int l = r; l >= 0; l--) {
                if (palTable[l][r]) {
                    dp[r + 1] = Math.min(dp[r + 1], dp[l] + cs[r - l]);
                }
            }
        }
        System.out.println(dp[n]);
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
