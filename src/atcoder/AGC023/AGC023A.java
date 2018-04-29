package atcoder.AGC023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class AGC023A {
    int n;
    int[] as;

    public static void main(String args[]) {
        new AGC023A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        long[] sums = new long[n + 2];
        for (int i = 1; i <= n; i++) {
            sums[i] = sums[i - 1] + as[i - 1];
        }
        sums[n + 1] = Long.MAX_VALUE;
        Arrays.sort(sums);
        long count = 0;
        long ans = 0;
        long prev = sums[0];
        for (int i = 1; i <= n + 1; i++) {
            if (prev != sums[i]) {
                prev = sums[i];
                ans += count * (count + 1) / 2;
                count = 0;
            } else {
                count++;
            }
        }
        System.out.println(ans);
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
