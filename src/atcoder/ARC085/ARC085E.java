package atcoder.ARC085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC085E {
    int n;
    int[] as;

    public static void main(String args[]) {
        new ARC085E().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            as[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        for (int i = n; i >= 1; i--) {
            long sum = 0;
            for (int j = i; j <= n; j += i) {
                sum += (long)as[j];
            }
            if (sum < 0) {
                for (int j = i; j <= n; j+= i) {
                    as[j] = 0;
                }
            }
        }
        long sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += as[i];
        }
        System.out.println(sum);
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
