package codeforces.Div3_479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Div3_479A {
    int n, k;

    public static void main(String args[]) {
        new Div3_479A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        solve();
    }

    void solve() {
        for (int i = 0; i < k; i++) {
            if (n % 10 > 0) {
                n--;
            } else {
                n /= 10;
            }
        }
        System.out.println(n);
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
