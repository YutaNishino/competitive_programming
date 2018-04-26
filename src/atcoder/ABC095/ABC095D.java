package atcoder.ABC095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC095D {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        long c = sc.nextLong();
        long[] xs = new long[n + 2];
        long[] vs = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            xs[i] = sc.nextLong();
            vs[i] = sc.nextLong();
        }
        xs[n + 1] = c;
        long maxCal = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = i + 1; j <= n + 1; j++) {
                long tempMaxCal = 0;
                for (int k = 1; k <= i; k++) {
                    tempMaxCal += vs[k];
                }
                for (int k = n; k >= j; k--) {
                    tempMaxCal += vs[k];
                }
                if (xs[i] > c - xs[j]) {
                    tempMaxCal -= xs[i] + 2 * (c - xs[j]);
                } else {
                    tempMaxCal -= 2 * xs[i] + c - xs[j];
                }
                maxCal = Math.max(maxCal, tempMaxCal);
            }
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
