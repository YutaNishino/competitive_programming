package atcoder.codeFlyer_qual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeFlyer_qual_C {
    int n, d;
    int[] xs;

    public static void main(String args[]) {
        new codeFlyer_qual_C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        d = sc.nextInt();
        xs = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        Combination c = new Combination(100000, Integer.MAX_VALUE);
        long ikLessD = 0;
        int[] memo = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int k = upper_bound(xs, xs[i] + d) - 1;
            if (k == n) {
                k--;
            }
            memo[i] = k;
            ikLessD += ((long)k - i) * (k - i - 1) / 2;
        }
        long sub = 0;
        for (int j = 0; j < n - 1; j++) {
            int k = memo[j];
            int i = lower_bound(xs, xs[j] - d);
            sub += (long)(j - i) * (k - j);
        }
        System.out.println(sub - ikLessD);
    }

    static int lower_bound(int[] arr, int key) {
        return lower_bound(arr, 0, arr.length - 1, key);
    }

    static int lower_bound(int[] arr, int beginIndex, int endIndex, int key) {
        int low = beginIndex;
        int high = endIndex;
        while (high - low >= 0) {
            int mid = (low + high) / 2;
            if (key <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upper_bound(int[] arr, int key) {
        return upper_bound(arr, 0, arr.length - 1, key);
    }

    static int upper_bound(int[] arr, int beginIndex, int endIndex, int key) {
        int low = beginIndex;
        int high = endIndex;
        while (high - low >= 0) {
            int mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    class Combination {
        long mod;
        long[] facts;
        long[] invs;
        long[] invFacts;

        public Combination(int max, long mod) {
            this.mod = mod;
            facts = new long[max + 2];
            invs = new long[max + 2];
            invFacts = new long[max + 2];
            invs[1] = 1;
            for (int i = 2; i <= max + 1; i++) {
                invs[i] = (long)((long)invs[(int)(mod % i)] * (mod - mod / i) % mod);
            }
            facts[0] = 1;
            invFacts[0] = 1;
            for (int i = 1; i <= max + 1; i++) {
                facts[i] = (long)(facts[i - 1] * (long)i % mod);
                invFacts[i] = (long)(invFacts[i - 1] * (long)invs[i] % mod);
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
