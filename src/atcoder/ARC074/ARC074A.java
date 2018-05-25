package atcoder.ARC074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC074A {
    int x, y;

    public static void main(String args[]) {
        new ARC074A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        x = sc.nextInt();
        y = sc.nextInt();
        solve();
    }

    void solve() {
        if (x == 2) {
            System.out.println("No");
        } else if (x == 4 || x == 6 || x == 9 || x == 11) {
            if (y == 6 || y == 9 || y == 11) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        } else {
            if (y == 2 || y == 4 || y == 6 || y == 9 || y == 11) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
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
