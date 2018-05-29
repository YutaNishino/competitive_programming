package atcoder.ABC001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC001B {
    int m;

    public static void main(String args[]) {
        new ABC001B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        m = sc.nextInt();
        solve();
    }

    void solve() {
        if (m > 70000) {
            System.out.println(89);
        } else if (m >= 35000) {
            System.out.println((m / 1000 - 30) / 5 + 80);
        } else if (m >= 6000) {
            System.out.println(m / 1000 + 50);
        } else if (m >= 100) {
            int val = m / 100;
            if (val < 10) {
                System.out.println("0" + val);
            } else {
                System.out.println(val);
            }
        } else {
            System.out.println("00");
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
