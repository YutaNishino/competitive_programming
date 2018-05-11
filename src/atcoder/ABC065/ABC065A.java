package atcoder.ABC065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC065A {
    int x, a, b;

    public static void main(String args[]) {
        new ABC065A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        x = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        solve();
    }

    void solve() {
        if (b <= a) {
            System.out.println("delicious");
        } else if (b <= a + x) {
            System.out.println("safe");
        } else {
            System.out.println("dangerous");
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
