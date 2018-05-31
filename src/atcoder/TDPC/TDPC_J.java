package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TDPC_J {
    int n;
    int[] xs;

    public static void main(String args[]) {
        new TDPC_J().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        xs = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int target = 0;
        for (int i = 0; i < n; i++) {
            target |= 1 << 15 - xs[i];
        }
        double[] dp = new double[1 << 16];
        Arrays.fill(dp, 1 << 30);
        for (int i = 0; i < (1 << 16); i++) {
            if (Integer.bitCount(i) == 1) {
                dp[i] = 3;
            }
            // throw at j
            for (int j = 1; j < 15; j++) {
                int mask = (1 << 16 - j);
                double temp = 0;
                int missCount = 0;
                for (int k = 0; k < 3; k++, mask >>= 1) {
                    int state = i & ~mask;
                    if (i == state) {
                        missCount++;
                        temp += 1.0 / 3;
                    } else {
                        temp += (dp[state] + 1) / 3;
                    }
                }
                if (missCount == 3) {
                    continue;
                } else if (missCount == 2) {
                    temp *= 3.0;
                } else if (missCount == 1) {
                    temp *= 3.0 / 2;
                }
                dp[i] = Math.min(dp[i], temp);
            }
        }
        System.out.println(dp[target]);
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
