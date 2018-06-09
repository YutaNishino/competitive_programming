package atcoder.indeed_now_final_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class indeed_now_final_B_A {
    int a, b;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new indeed_now_final_B_A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        solve();
    }

    void solve() {
        long[] weights = new long[1000001];
        for (int i = 1; i <= 1000000; i++) {
            weights[i] = (weights[i - 1] + (long)i * i * (i + 1) / 2 % MOD) % MOD;
        }
        System.out.println((weights[b] - weights[a - 1] + MOD) % MOD);
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
