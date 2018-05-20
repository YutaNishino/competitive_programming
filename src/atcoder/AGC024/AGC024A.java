package atcoder.AGC024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AGC024A {
    long a, b, c;
    long k;

    public static void main(String args[]) {
        new AGC024A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        k = sc.nextLong();
        solve();
    }

    void solve() {
        if (k % 2 == 1) {
            System.out.println(b - a);
        } else {
            System.out.println(a - b);
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
