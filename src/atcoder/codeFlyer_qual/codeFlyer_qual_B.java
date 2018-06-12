package atcoder.codeFlyer_qual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeFlyer_qual_B {
    int a, b, n;
    char[] cs;

    public static void main(String args[]) {
        new codeFlyer_qual_B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        n = sc.nextInt();
        cs = new char[n];
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'S') {
                if (a > 0) {
                    a--;
                }
            } else if (cs[i] == 'C') {
                if (b > 0) {
                    b--;
                }
            } else {
                if (a > 0 && a >= b) {
                    a--;
                } else if (b > 0) {
                    b--;
                }
            }
        }
        System.out.println(a);
        System.out.println(b);
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
