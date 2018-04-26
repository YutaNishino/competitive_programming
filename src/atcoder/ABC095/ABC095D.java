package atcoder.ABC095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC095D {
    int n;
    long c;
    long[] xs, vs;

    public static void main(String args[]) {
        new ABC095D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        c = sc.nextLong();
        xs = new long[n + 2];
        vs = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            xs[i] = sc.nextLong();
            vs[i] = sc.nextLong();
        }
        xs[n + 1] = c;
        solve();
    }

    void solve() {
        long[] vSumToI = new long[n + 1];
        long[] vSumToI2 = new long[n + 1];
        long[] vSumToJ = new long[n + 2];
        long[] maxVSumForJ = new long[n + 1];
        long[] maxVSumForJ2 = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            vSumToI[i] = vSumToI[i - 1] + vs[i];
            vSumToI2[i] = vSumToI2[i - 1]+ vs[i];
        }
        for (int i = n; i >= 1; i--) {
            vSumToJ[i] = vSumToJ[i + 1] + vs[i];
        }
        for (int i = 1; i <= n; i++) {
            maxVSumForJ[i] = Math.max(maxVSumForJ[i - 1],
                    vSumToI[i] - xs[i]);
            maxVSumForJ2[i] = Math.max(maxVSumForJ2[i - 1],
                    vSumToI[i] - 2 * xs[i]);
        }
        long maxCal = 0;
        for (int i = 1; i <= n + 1; i++) {
            long tempMaxCal = maxVSumForJ[i - 1] +
                    vSumToJ[i] - 2 * (c - xs[i]);
            maxCal = Math.max(maxCal, tempMaxCal);
            long tempMaxCal2 = maxVSumForJ2[i - 1] + vSumToJ[i] - c + xs[i];
            maxCal = Math.max(maxCal, tempMaxCal2);
        }
        System.out.println(maxCal);
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
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

        String nextLine()
        {
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
