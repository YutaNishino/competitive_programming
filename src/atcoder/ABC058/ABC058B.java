package atcoder.ABC058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC058B {
    String o, e;
    StringBuilder sb;

    public static void main(String args[]) {
        new ABC058B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        o = sc.next();
        e = sc.next();
        solve();
    }

    void solve() {
        sb = new StringBuilder();
        for (int i = 0; i < e.length(); i++) {
            sb.append(o.charAt(i));
            sb.append(e.charAt(i));
        }
        if (o.length() > e.length()) {
            sb.append(o.charAt(o.length() - 1));
        }
        System.out.println(sb);
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
