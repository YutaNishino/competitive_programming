package atcoder.ABC064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC064A {
    int r, g, b;

    public static void main(String args[]) {
        new ABC064A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        r = sc.nextInt();
        g = sc.nextInt();
        b = sc.nextInt();
        solve();
    }

    void solve() {
        if ((r * 100 + g * 10 + b) % 4 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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
