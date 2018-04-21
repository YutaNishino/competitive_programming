package atcoder.ABC095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ABC095D {
    static int n;
    static long c;
    static long[] xs, vs;
    static Map<Long, Integer> compressedX;
    static Map<Integer, Long> rCompressedX;
    static long[] dp;
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        c = sc.nextLong();
        xs = new long[n + 2];
        vs = new long[n + 2];
        xs[0] = 0;
        xs[n + 1] = c;
        vs[0] = 0;
        vs[n + 1] = 0;
        dp = new long[n + 2];
        compressedX = new HashMap<>();
        rCompressedX = new HashMap<>();
        compressedX.put(0l, 0);
        rCompressedX.put(0, 0l);
        for (int i = 1; i <= n; i++) {
            xs[i] = sc.nextLong();
            compressedX.put(xs[i], i);
            rCompressedX.put(i, xs[i]);
            vs[i] = sc.nextLong();
        }

        System.out.println(rec(1, n, 0));
    }

    static long rec(int next, int prev, int now) {
        System.out.println(now);
        if (next > prev) return 0;
        if (dp[now] > 0) return dp[now];
        long nextDistance = (xs[next + 1] + c - rCompressedX.get(now)) % c;
        long prevDistance = (rCompressedX.get(now) + c - xs[prev - 1]) % c;
        long forward = rec(next + 1, prev, 1) + vs[next] - nextDistance;
        dp[now + 1] = Math.max(dp[now + 1], forward);
        long backward = rec(next, prev - 1, 0) + vs[prev] - prevDistance;
        dp[(now + n) % (n + 1)] = Math.max(dp[(now + n) % (n + 1)], backward);
        long ans = Math.max(0, Math.max(forward, backward));
        return ans;
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
