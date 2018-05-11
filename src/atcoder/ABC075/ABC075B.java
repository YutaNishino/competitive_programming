package atcoder.ABC075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC075B {
    int h, w;
    char[][] css;

    public static void main(String args[]) {
        new ABC075B().run();
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
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (css[i][j] == '#') {
                    System.out.print('#');
                    continue;
                }
                int count = 0;
                if (i > 0) {
                    if (j > 0) {
                        if (css[i - 1][j - 1] == '#') {
                            count++;
                        }
                    }
                    if (j < w - 1) {
                        if (css[i - 1][j + 1] == '#') {
                            count++;
                        }
                    }
                    if (css[i - 1][j] == '#') {
                        count++;
                    }
                }
                if (i < h - 1) {
                    if (j > 0) {
                        if (css[i + 1][j - 1] == '#') {
                            count++;
                        }
                    }
                    if (j < w - 1) {
                        if (css[i + 1][j + 1] == '#') {
                            count++;
                        }
                    }
                    if (css[i + 1][j] == '#') {
                        count++;
                    }
                }
                if (j > 0 && css[i][j - 1] == '#') {
                    count++;
                }
                if (j < w - 1 && css[i][j + 1] == '#') {
                    count++;
                }
                System.out.print(count);
            }
            System.out.println();
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
