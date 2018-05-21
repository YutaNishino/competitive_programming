package atcoder.ABC002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC002C {
    int xa, ya, xb, yb, xc, yc;

    public static void main(String args[]) {
        new ABC002C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        xa = sc.nextInt();
        ya = sc.nextInt();
        xb = sc.nextInt();
        yb = sc.nextInt();
        xc = sc.nextInt();
        yc = sc.nextInt();
        solve();
    }

    void solve() {
        System.out.printf("%4f\n", (Math.abs((double)(xb - xa) * (yc - ya) -
                (yb - ya) * (xc - xa))) / 2);
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
