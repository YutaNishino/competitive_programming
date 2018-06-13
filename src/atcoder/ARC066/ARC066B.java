package atcoder.ARC066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC066B {
    int n, m;
    int[] ts, ps, xs;

    public static void main(String args[]) {
        new ARC066B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        ts = new int[n];
        for (int i = 0; i < n; i++) {
            ts[i] = sc.nextInt();
        }
        m = sc.nextInt();
        ps = new int[m];
        xs = new int[m];
        for (int i = 0; i < m; i++) {
            ps[i] = sc.nextInt() - 1;
            xs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (j == ps[i]) {
                    sum += xs[i];
                } else {
                    sum += ts[j];
                }
            }
            System.out.println(sum);
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
