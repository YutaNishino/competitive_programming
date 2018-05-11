package atcoder.ABC067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC067C {
    int n;
    long[] as;

    public static void main(String args[]) {
        new ABC067C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new long[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextLong();
        }
        solve();
    }

    void solve() {
        long[] ss = new long[n];
        ss[0] = as[0];
        for (int i = 1; i < n; i++) {
            ss[i] = ss[i - 1] + as[i];
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < n - 1; i++) {
            long snuke = ss[i];
            long raccoon = ss[n - 1] - ss[i];
            long diff = Math.abs(snuke - raccoon);
            if (diff < min) {
                min = diff;
            }
        }
        System.out.println(min);
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
