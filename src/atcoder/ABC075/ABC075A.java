package atcoder.ABC075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC075A {
    int a, b, c;

    public static void main(String args[]) {
        new ABC075A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        solve();
    }

    void solve() {
        if (a == b) {
            System.out.println(c);
        } else if (b == c) {
            System.out.println(a);
        } else {
            System.out.println(b);
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