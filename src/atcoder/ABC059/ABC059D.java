package atcoder.ABC059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC059D {
    long n, m;

    public static void main(String args[]) {
        new ABC059D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextLong();
        m = sc.nextLong();
        solve();
    }

    void solve() {
        if (n > m) {
            long temp = n;
            n = m;
            m = temp;
        }
        String ans = "Alice";
        if (n == m || n == m - 1) {
            ans = "Brown";
        }
        System.out.println(ans);
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
