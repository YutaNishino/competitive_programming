package atcoder.ARC060;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC060D {
    long n, s;

    public static void main(String args[]) {
        new ARC060D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextLong();
        s = sc.nextLong();
        solve();
    }

    void solve() {
        long sqrtN = (long)Math.sqrt(n);
        long minB = -1;
        if (n <= s) {
            if (n == s) {
                minB = n + 1;
            }
            System.out.println(minB);
            return;
        }
        for (int b = 2; b <= sqrtN; b++) {
            long copyN = n;
            long sumDigits = 0;
            while (copyN > 0) {
                sumDigits += copyN % b;
                copyN /= b;
            }
            if (sumDigits == s) {
                minB = b;
                break;
            }
        }
        if (minB == -1) {
            for (long p = sqrtN; p >= 1; p--) {
                long b = (n - s)/ p + 1;
                if (b <= 1) {
                    continue;
                }
                long copyN = n;
                long sumDigits = 0;
                while (copyN > 0) {
                    sumDigits += copyN % b;
                    copyN /= b;
                }
                if (sumDigits == s) {
                    minB = b;
                    break;
                }
            }
        }
        System.out.println(minB);
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
