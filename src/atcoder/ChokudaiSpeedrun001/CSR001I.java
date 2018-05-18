package atcoder.ChokudaiSpeedrun001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CSR001I {
    int n;
    int[] as;

    public static void main(String args[]) {
        new CSR001I().run();
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
        int[] cumSums = new int[n + 1];
        cumSums[1] = as[0];
        for (int i = 2; i <= n; i++) {
            cumSums[i] = cumSums[i - 1] + as[i - 1];
        }
        int l = 0;
        int r = 1;
        int count = 0;
        while (true) {
            int tempSum = cumSums[r] - cumSums[l];
            if (r == n) {
                if (l == n || tempSum < n) {
                    break;
                }
            }
            if (tempSum == n) {
                count++;
                if (r < n) {
                    r++;
                } else {
                    break;
                }
            } else if (tempSum > n) {
                l++;
            } else {
                r++;
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
