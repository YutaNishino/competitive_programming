package atcoder.ABC077;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC077A {
    char[][] css;

    public static void main(String args[]) {
        new ABC077A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        css = new char[2][3];
        for (int i = 0; i < 2; i++) {
            css[i] = sc.next().toCharArray();
        }
        solve();
    }

    void solve() {
        if (css[0][0] == css[1][2] && css[0][1] == css[1][1] &&
                css[0][2] == css[1][0]) {
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
