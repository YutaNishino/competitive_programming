package atcoder.ABC047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC047D {
    int n;
    long t;
    int[] as;

    public static void main(String args[]) {
        new ABC047D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        t = sc.nextLong();
        as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int max = as[n - 1];
        int maxProfit = 0;
        int maxProfitCount = 0;
        for (int i = n - 2; i >= 0; i--) {
            int tempMaxProfit = max - as[i];
            if (tempMaxProfit > maxProfit) {
                maxProfit = tempMaxProfit;
                maxProfitCount = 1;
            } else if (tempMaxProfit == maxProfit) {
                maxProfitCount++;
            }
            if (max < as[i]) {
                max = as[i];
            }
        }
        System.out.println(maxProfitCount);
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
