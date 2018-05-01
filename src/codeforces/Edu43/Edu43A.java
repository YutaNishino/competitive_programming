package codeforces.Edu43;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Edu43A {
    int n;
    String s;

    public static void main(String args[]) {
        new Edu43A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        s = sc.next();
        solve();
    }

    void solve() {
        int firstIndex = s.indexOf("1");
        if (firstIndex < 0) {
            System.out.println("0");
            System.exit(0);
        }
        int count = s.length() - s.replace("1", "").length();
        if (count > 1) {
            StringBuilder sb = new StringBuilder(s.substring(0, firstIndex + 1));
            for (int i = 0; i < s.length() - firstIndex - count; i++) {
                sb.append("0");
            }
            s = sb.toString();
        }
        System.out.println(s);
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
