package atcoder.ABC100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC100B {
    int d, n;

    public static void main(String args[]) {
        new ABC100B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        d = sc.nextInt();
        n = sc.nextInt();
        solve();
    }

    void solve() {
        int start = 1;
        if (d == 1) {
            start = 100;
        } else if (d == 2) {
            start = 10000;
        }
        if (n < 100) {
            System.out.println(start * n);
        } else {
            System.out.println(start * 101);
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
