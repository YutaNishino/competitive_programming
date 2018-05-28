package atcoder.ABC004;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC004B {
    char[][] css;

    public static void main(String args[]) {
        new ABC004B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        css = new char[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                css[i][j] = sc.next().charAt(0);
            }
        }
        solve();
    }

    void solve() {
        for (int i = 3; i >= 0; i--) {
            for (int j = 3; j >= 0; j--) {
                System.out.print(css[i][j]);
                if (j > 0) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
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
