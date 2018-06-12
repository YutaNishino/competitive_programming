package atcoder.AGC025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AGC025B {
    int n, a, b;
    long k;
    int MOD = 998244353;

    public static void main(String args[]) {
        new AGC025B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        k = sc.nextLong();
        solve();
    }

    void solve() {
        //long[][] dp = new long[n + 1][];
        //dp[0][0] = 1;
        Combination c = new Combination(300000, MOD);
        long ans = 0;
        int min = (int)(k / (a + b));
        int max = (int)(k / Math.min(a, b));
        /*
        for (int p = min; p <= max; p++) {

        }
        */
        /*
        long ab = (long)(a + b);
        for (int z = 0; z <= n && ab * z <= k; z++) {
            System.out.println(z);
            long xl = (int)(((b - 1) * k - b * ab * z) / (a * (b - 1)));
            long yl = (k - a * xl) / b;
            if (xl < 0 || yl < 0) {
                continue;
            }
            if (xl > n || yl > n) {
                continue;
            }
            int x = (int)xl;
            int y = (int)yl;
            System.out.println(z + " " + xl + " " + x + " " + yl + " " + y);
            ans = (ans + c.comb(n, x) * c.comb(n - x, y) % MOD *
                    c.comb(n - x - y, z) % MOD) % MOD;
        }
        System.out.println(ans);
        */


        for (int p = 0; p <= 2 * n && p * Math.min(a, b) <= k; p++) {
            long temp = k - p * a;
            if (temp % b == 0) {
                long t = temp / b;
                if (t > n) {
                    continue;
                }
                int m = (int)t;
                for (int l = 0; l <= Math.min(p, m); l++) {
                    //System.out.println(p + " " + m + " " + l);
                    //System.out.println(n + " " + (p - l) + " " + c.comb(n, p - l));
                    //System.out.println((n - p + l) + " " + (m - l) + " " + c.comb(n - p + l, m - l));
                    //System.out.println((n - p - m + 2*l) + " " + l + " " + c.comb(n - p - m + 2 * l, l));
                    ans = (ans + c.comb(n, p - l) * c.comb(n - p + l, m - l) % MOD *
                            c.comb(n - p - m + 2 * l, l) % MOD) % MOD;
                }
            }
        }
        System.out.println(ans);
    }

    class Combination {
        long mod;
        int[] facts;
        int[] invs;
        int[] invFacts;

        public Combination(int max, int mod) {
            this.mod = mod;
            facts = new int[max + 2];
            invs = new int[max + 2];
            invFacts = new int[max + 2];
            invs[1] = 1;
            for (int i = 2; i <= max + 1; i++) {
                invs[i] = (int)((long)invs[mod % i] * (mod - mod / i) % mod);
            }
            facts[0] = 1;
            invFacts[0] = 1;
            for (int i = 1; i <= max + 1; i++) {
                facts[i] = (int)(facts[i - 1] * (long)i % mod);
                invFacts[i] = (int)(invFacts[i - 1] * (long)invs[i] % mod);
            }
        }

        long comb (int n, int k) {
            if (k < 0 || k > n) return 0;
            return facts[n] * (long)invFacts[k] % mod * (long)invFacts[n - k] % mod;
        }

        long combRep(int n, int k) {
            return comb(n + k - 1, k);

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
