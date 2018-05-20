package atcoder.AGC024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AGC024C {
    int n;
    int[] as;

    public static void main(String args[]) {
        new AGC024C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        if (as[0] > 0) {
            System.out.println(-1);
            return;
        }
        long[] dp = new long[n];
        dp[n - 1] = as[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (as[i] >= as[i + 1]) {
                dp[i] = dp[i + 1] + as[i];
            } else if (as[i] == as[i + 1] - 1) {
                dp[i] = dp[i + 1];
            } else {
                System.out.println(-1);
                return;
            }
        }
        System.out.println(dp[0]);
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
