package atcoder.ABC041;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC041D {
    int n, m;
    int[] xs, ys;

    public static void main(String args[]) {
        new ABC041D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        xs = new int[m];
        ys = new int[m];
        for (int i = 0; i < m; i++) {
            xs[i] = sc.nextInt() - 1;
            ys[i] = sc.nextInt() - 1;
        }
        solve();
    }

    void solve() {
        long[] dp = new long[1 << n];
        dp[0] = 1;
        for (int state = 0; state < dp.length; state++) {
            boolean[] endConstraints = new boolean[n];
            for (int j = 0; j < m; j++) {
                //if (((1 << xs[j]) & state) > 0 && )
                //endConstraints[j] = ;
            }
        }


        int[] constraints = new int[n];
        for (int i = 0; i < m; i++) {
            constraints[xs[i]]++;
            constraints[ys[i]]++;
        }
        long[] factorials = fillFactorial(16);
        long possibility = factorials[n];
        for (int i = 0; i < n; i++) {
            possibility /= constraints[i] + 1;
        }
        System.out.println(possibility);
    }

    long[] fillFactorial(int max) {
        long[] facts = new long[max + 1];
        facts[0] = 1;
        for (int i = 1; i < facts.length; i++) {
            facts[i] = facts[i - 1] * i;
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
