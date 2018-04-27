package atcoder.ABC017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC017A {
    int s1, s2, s3, e1, e2, e3;

    public static void main(String args[]) {
        new ABC017A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        s1 = sc.nextInt();
        e1 = sc.nextInt();
        s2 = sc.nextInt();
        e2 = sc.nextInt();
        s3 = sc.nextInt();
        e3 = sc.nextInt();
        solve();
    }

    void solve() {
        System.out.println(s1 / 10 * e1 + s2 / 10 * e2 + s3 / 10 * e3);
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
