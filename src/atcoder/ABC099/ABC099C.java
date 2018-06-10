package atcoder.ABC099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABC099C {
    int n;

    public static void main(String args[]) {
        new ABC099C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        solve();
    }

    void solve() {
        int[] candidates = {1, 6, 36, 216, 6 * 6 * 6 * 6,
            6 * 6* 6 * 6* 6, 6 * 6 * 6 * 6 * 6 * 6, 9, 81, 729,
            9 * 9 * 9 * 9, 9 * 9 * 9* 9* 9};
        int[] dp = new int[100001];
        Arrays.fill(dp, 1 << 30);
        dp[0] = 0;
        for (int i = 0; i < 100001; i++) {
            for (int j = 0; j < candidates.length; j++) {
                if (candidates[j] > i) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - candidates[j]] + 1);
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
