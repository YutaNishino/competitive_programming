package atcoder.ABC006;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC006A {
    int n;

    public static void main(String args[]) {
        new ABC006D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        solve();
    }

    void solve() {
        boolean flag = false;
        if (n % 3 == 0) {
            flag = true;
        }
        while (!flag && n > 0) {
            if (n % 10 == 3) {
                flag = true;
            }
            n /= 10;
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
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
