package atcoder.ABC084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC084C {
    int n;
    int[] cs, ss, fs;

    public static void main(String args[]) {
        new ABC084C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        cs = new int[n - 1];
        ss = new int[n - 1];
        fs = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            cs[i] = sc.nextInt();
            ss[i] = sc.nextInt();
            fs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int[] times = new int[n];
        for (int j = 0; j < n - 1; j++) {
            int time = 0;
            for (int i = j; i < n - 1; i++) {
                if (time < ss[i]) {
                    time = ss[i];
                }
                if (time % fs[i] != 0) {
                    time = (time / fs[i] + 1) * fs[i];
                }
                time += cs[i];
            }
            times[j] = time;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(times[i]);
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
