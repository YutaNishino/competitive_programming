package atcoder.ABC097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC097B {
    int x;

    public static void main(String args[]) {
        new ABC097B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        x = sc.nextInt();
        solve();
    }

    void solve() {
        int sqrtX = (int)Math.sqrt(x);
        int ans = 1;
        for (int i = 2; i <= sqrtX; i++) {
            int temp = i;
            while (temp <= x) {
                temp *= i;
            }
            temp /= i;
            if (ans < temp) {
                ans = temp;
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
