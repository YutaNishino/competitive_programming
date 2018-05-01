package codeforces.Edu43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Edu43B {
    int n, m;
    long k;

    public static void main(String args[]) {
        new Edu43B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextLong();
        solve();
    }

    void solve() {
        long ansX = 0;
        long ansY = 0;
        if (k < n) {
            ansX = (int)k + 1;
            ansY = 1;
        } else {
            k -= n;
            long count = k / (m - 1);
            ansX = n - count;
            if (count % 2 == 0) {
                ansY = 2 + (int)(k % (m - 1));
            } else {
                ansY = m - (int)(k % (m - 1));
            }
            /*
            while (true) {
                if (k <= m - 2) {
                    ansX = n - count;
                    if (count % 2 == 0) {
                        ansY = 2 + (int)k;
                    } else {
                        ansY = m - (int)k;
                    }
                    break;
                }
                k -= m - 2;
                if (k == 1) {
                    ansX = n - count - 1;
                    if (count % 2 == 0) {
                        ansY = m;
                    } else {
                        ansY = 2;
                    }
                }
                k--;
                count++;
            }
            */
        }
        System.out.printf("%d %d\n", ansX, ansY);
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
