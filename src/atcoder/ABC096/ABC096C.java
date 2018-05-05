package atcoder.ABC096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC096C {
    int h, w;
    char[][] css;

    public static void main(String args[]) {
        new ABC096C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        w = sc.nextInt();
        css = new char[h][];
        for (int i = 0; i < h; i++) {
            css[i] = sc.next().toCharArray();
        }
        solve();
    }

    void solve() {
        boolean flag = true;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                boolean ok = false;
                if (css[i][j] == '.') {
                    continue;
                }
                if (i > 0) {
                    if (css[i - 1][j] == css[i][j]) {
                        ok = true;
                    }
                }
                if (j > 0) {
                    if (css[i][j - 1] == css[i][j]) {
                        ok = true;
                    }
                }
                if (i < css.length - 1) {
                    if (css[i + 1][j] == css[i][j]) {
                        ok = true;
                    }
                }
                if (j < css[i].length - 1) {
                    if (css[i][j + 1] == css[i][j]) {
                        ok = true;
                    }
                }
                if (!ok) {
                    System.out.println("No");
                    return;
                }
            }
        }
        System.out.println("Yes");
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
