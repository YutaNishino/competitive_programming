package atcoder.ABC099;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC099D {
    int n, c;
    int[][] dss, css;

    public static void main(String args[]) {
        new ABC099D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        c = sc.nextInt();
        dss = new int[c][c];
        css = new int[n][n];
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                dss[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                css[i][j] = sc.nextInt() - 1;
            }
        }
        solve();
    }

    void solve() {
        int[][] costs = new int[3][c];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < c; k++) {
                    costs[(i + j) % 3][k] += dss[css[i][j]][k];
                }
            }
        }
        boolean[] used = new boolean[c];
        long ans = 1 << 60;
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < c; k++) {
                    if (i == j || j == k || k == i) {
                        continue;
                    }
                    ans = Math.min(ans, costs[0][i] + costs[1][j] + costs[2][k]);
                }
            }
        }
        System.out.println(ans);
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
