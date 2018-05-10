package atcoder.ABC079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC079A {
    int n;

    public static void main(String args[]) {
        new ABC079A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        solve();
    }

    void solve() {
        int pPrevDigit = -1;
        int prevDigit = -1;
        while(n > 0) {
            int digit = n % 10;
            if (pPrevDigit == digit) {
                System.out.println("Yes");
                return;
            } else if (prevDigit == digit || prevDigit == -1) {
                pPrevDigit = prevDigit;
                prevDigit = digit;
            } else {
                pPrevDigit = -1;
                prevDigit = digit;
            }
            n /= 10;
        }
        System.out.println("No");
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
