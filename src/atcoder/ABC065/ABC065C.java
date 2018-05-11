package atcoder.ABC065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC065C {
    int n, m;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new ABC065C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        solve();
    }

    void solve() {
        if (n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        if (m - n > 1) {
            System.out.println(0);
            return;
        }
        long ans = 0;
        long[] facts = fillFactorial(m, MOD);
        if (n == m) {
            ans = 2 * facts[n] * facts[m] % MOD;
        } else {
            ans = facts[n] * facts[m] % MOD;
        }
        System.out.println(ans);
    }

    long[] fillFactorial(int max, int mod) {
        long[] facts = new long[max + 1];
        facts[0] = 1;
        for (int i = 1; i < facts.length; i++) {
            facts[i] = facts[i - 1] * i % mod;
        }
        return facts;
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
