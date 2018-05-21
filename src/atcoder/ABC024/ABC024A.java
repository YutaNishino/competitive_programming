package atcoder.ABC024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC024A {
    int a, b, c, k, s, t;

    public static void main(String args[]) {
        new ABC024A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        k = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt();
        solve();
    }

    void solve() {
        int cost = a * s + b * t;
        if (s + t >= k) {
            cost -= (s + t) * c;
        }
        System.out.println(cost);
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
