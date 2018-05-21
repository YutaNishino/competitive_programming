package atcoder.ABC006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC006C {
    int n, m;

    public static void main(String args[]) {
        new ABC006C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        solve();
    }

    void solve() {
        int a = 0;
        int b = 0;
        int c = 0;
        if (m % 2 == 1) {
            b = 1;
            m -= 3;
            n--;
        }
        if (m < 2 * n || 4 * n < m) {
            System.out.println("-1 -1 -1");
            return;
        }
        while (true) {
            if (m > 2 * n) {
                c++;
                m -= 4;
                n--;
            } else {
                a++;
                m -= 2;
                n--;
            }
            if (m == 0 && n == 0) {
                System.out.println(a + " " + b + " " + c);
                return;
            } else if (m <= 0 || n <= 0) {
                System.out.println("-1 -1 -1");
                return;
            }
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
