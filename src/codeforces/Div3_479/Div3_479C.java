package codeforces.Div3_479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Div3_479C {
    int n, k;
    int[] as;

    public static void main(String args[]) {
        new Div3_479C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        Arrays.sort(as);
        int ans = 0;
        if (k == 0) {
            if (as[0] == 1) {
                ans = -1;
            } else {
                ans = 1;
            }
        } else if (k == 1) {
            if (n == 1) {
                ans = as[0];
            } else if (as[0] == as[1]) {
                ans = -1;
            } else {
                ans = as[0];
            }
        } else if (k > 1) {
            if (k == n) {
                ans = as[n - 1];
            } else {
                if (as[k - 2] == as[k - 1] || as[k - 1] == as[k]) {
                    ans = -1;
                } else {
                    ans = as[k - 1];
                }
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
