package atcoder.ABC057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC057C {
    long n;

    public static void main(String args[]) {
        new ABC057C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextLong();
        solve();
    }

    void solve() {
        int sqrtN = (int)Math.sqrt(n) + 1;
        int minDigit = Integer.MAX_VALUE;
        for (long i = 1; i <= sqrtN; i++) {
            if (n % i > 0) {
                continue;
            }
            long j = n / i;
            int digit = f(i, j);
            if (digit < minDigit) {
                minDigit = digit;
            }
        }
        System.out.println(minDigit);
    }

    int f(long a, long b) {
        int digitA = digit(a);
        int digitB = digit(b);
        if (digitA < digitB) {
            return digitB;
        }
        return digitA;
    }

    int digit(long a) {
        int ret = 0;
        for (; a > 0; ++ret) {
            a /= 10;
        }
        return ret;
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
