package atcoder.ABC026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABC026B {
    int n;
    int[] rs;

    public static void main(String args[]) {
        new ABC026B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        rs = new int[n];
        for (int i = 0; i < n; i++) {
            rs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        Arrays.sort(rs);
        double area = 0;
        int count = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (count == 0) {
                area += rs[i] * rs[i];
            } else {
                area -= rs[i] * rs[i];
            }
            count = (count + 1) % 2;
        }
        System.out.println(area * Math.PI);
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
