package atcoder.ABC059;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC059A {
    String s1, s2, s3;

    public static void main(String args[]) {
        new ABC059A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        s1 = sc.next();
        s2 = sc.next();
        s3 = sc.next();
        solve();
    }

    void solve() {
        System.out.println(s1.substring(0, 1).toUpperCase() +
                s2.substring(0, 1).toUpperCase() +
                s3.substring(0, 1).toUpperCase());
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
