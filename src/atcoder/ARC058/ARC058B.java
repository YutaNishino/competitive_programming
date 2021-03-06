package atcoder.ARC058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ARC058B {
    int n, l;
    String[] ss;

    public static void main(String args[]) {
        new ARC058B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        l = sc.nextInt();
        ss = new String[n];
        for (int i = 0; i < n ; i++) {
            ss[i] = sc.next();
        }
        solve();
    }

    void solve() {
        Arrays.sort(ss);
        for (int i = 0; i < n; i++) {
            System.out.print(ss[i]);
        }
        System.out.println();
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
