package atcoder.ABC076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC076D {
    int n;
    int[] ts, vs;

    public static void main(String args[]) {
        new ABC076D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        ts = new int[n];
        vs = new int[n];
        for (int i = 0; i < n; i++) {
            ts[i] = sc.nextInt();
            vs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int[] remainTimes = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            remainTimes[i] = ts[i + 1] + remainTimes[i + 1];
        }
        double distance = 0.0;
        int prevVelocity = 0;
        for (int i = 0; i < n - 1; i++) {
            if (remainTimes[i] >= vs[i] && vs[i + 1] >= vs[i]) {

            }
        }
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
