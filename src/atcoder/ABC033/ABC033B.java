package atcoder.ABC033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC033B {
    int n;
    String[] ss;
    int[] ps;
    int sum;

    public static void main(String args[]) {
        new ABC033B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        ss = new String[n];
        ps = new int[n];
        sum = 0;
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
            ps[i] = sc.nextInt();
            sum += ps[i];
        }
        solve();
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            if (ps[i] * 2 > sum) {
                System.out.println(ss[i]);
                return;
            }
        }
        System.out.println("atcoder");
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
