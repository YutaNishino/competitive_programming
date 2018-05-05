package atcoder.ABC059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class ABC059B {
    BigInteger a, b;

    public static void main(String args[]) {
        new ABC059B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = new BigInteger(sc.next());
        b = new BigInteger(sc.next());
        solve();
    }

    void solve() {
        int res = a.compareTo(b);
        if (res > 0) {
            System.out.println("GREATER");
        } else if (res < 0) {
            System.out.println("LESS");
        } else {
            System.out.println("EQUAL");
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
