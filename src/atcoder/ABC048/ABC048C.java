package atcoder.ABC048;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC048C {
    int n, x;
    int[] as;

    public static void main(String args[]) {
        new ABC048C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        x = sc.nextInt();
        as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        long count = 0;
        for (int i = 0; i < n - 1; i++) {
            if (as[i] + as[i + 1] > x) {
                count += as[i] + as[i + 1] - x;
                if (x <= as[i]) {
                    as[i] = x;
                    as[i + 1] = 0;
                } else {
                    as[i + 1] = x - as[i];
                }
            }
        }
        System.out.println(count);
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
