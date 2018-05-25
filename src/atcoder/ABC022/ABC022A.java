package atcoder.ABC022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC022A {
    int n, s, t;

    public static void main(String args[]) {
        new ABC022A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        s = sc.nextInt();
        t = sc.nextInt();
        int w = 0;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int a = sc.nextInt();
            w += a;
            if (s <= w && w <= t) {
                ans++;
            }
        }
        System.out.println(ans);
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
