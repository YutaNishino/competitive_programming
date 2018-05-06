package atcoder.ABC057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC057B {
    int n, m;
    int[] as, bs, cs, ds;

    public static void main(String args[]) {
        new ABC057B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        as = new int[n];
        bs = new int[n];
        cs = new int[m];
        ds = new int[m];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
            bs[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            cs[i] = sc.nextInt();
            ds[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            int minDistance = Integer.MAX_VALUE;
            int minCheckpoint = -1;
            for (int j = 0; j < m; j++) {
                int manhattan = Math.abs(as[i] - cs[j]) + Math.abs(bs[i] - ds[j]);
                if (manhattan < minDistance) {
                    minDistance = manhattan;
                    minCheckpoint = j;
                }
            }
            System.out.println(minCheckpoint + 1);
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
