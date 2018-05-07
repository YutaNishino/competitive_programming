package atcoder.ABC074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC074B {
    int n, k;
    int[] xs;

    public static void main(String args[]) {
        new ABC074B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        xs = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (xs[i] < k - xs[i]) {
                ans += xs[i];
            } else {
                ans += k - xs[i];
            }
        }
        System.out.println(2 * ans);
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
