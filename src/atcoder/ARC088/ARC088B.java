package atcoder.ARC088;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC088B {
    int n, a, b;

    public static void main(String args[]) {
        new ARC088B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        solve();
    }

    void solve() {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int digitSum = digitSum(i);
            if (a <= digitSum && digitSum <= b) {
                ans += i;
            }
        }
        System.out.println(ans);
    }

    int digitSum(int m) {
        int ret = 0;
        while (m > 0) {
            ret += m % 10;
            m /= 10;
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
