package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TDPC_O {
    int[] freqs;
    int length = 0;
    int[] lengths;
    int count = 0;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new TDPC_O().run();
    }

    void run() {
        FastReader sc = new FastReader();
        freqs = new int[26];
        lengths = new int[27];
        for (int i = 0; i < 26; i++) {
            freqs[i] = sc.nextInt();
            length += freqs[i];
            if (freqs[i] > 0) {
                count++;
                lengths[count] = freqs[i] + lengths[count - 1];
            }
        }
        solve();
    }

    void solve() {
        Combination c = new Combination(length + 1, MOD);
        long[][] dp = new long[count + 1][length + 1];
        dp[0][0] = 1;
        int index = 0;
        for (int i = 0; index < 26; index++) {
            if (freqs[index] == 0) {
                continue;
            }
            for (int j = 0; j <= lengths[i]; j++) {
                for (int k = 1; k <= freqs[index]; k++) {
                    for (int l = 0; l <= Math.min(j, k); l++) {
                        long t = c.comb(freqs[index] - 1, k - 1);
                        t *= c.comb(j, l);
                        t %= MOD;
                        t *= c.comb(lengths[i] - j + 1, k - l);
                        t %= MOD;
                        t *= dp[i][j];
                        t %= MOD;
                        dp[i + 1][j - l + freqs[index] - k] += t;
                        dp[i + 1][j - l + freqs[index] - k] %= MOD;
                    }
                }
            }
            i++;
        }
        System.out.println(dp[count][0]);
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
