package atcoder.AGC025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AGC025A {
    int n;

    public static void main(String args[]) {
        new AGC025A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        solve();
    }

    void solve() {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n / 2; i++) {
            int iT = i;
            int j = n - i;
            int iDig = 0;
            int jDig = 0;
            while (iT > 0) {
                iDig += iT % 10;
                iT /= 10;
            }
            while (j > 0) {
                jDig += j % 10;
                j /= 10;
            }
            if (iDig + jDig < min) {
                min = iDig + jDig;
            }
        }
        System.out.println(min);
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
