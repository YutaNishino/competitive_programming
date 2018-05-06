package atcoder.ABC089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC089D {
    int h, w, d, q;
    int[][] ass;
    int[] ls, rs, xs, ys;

    public static void main(String args[]) {
        new ABC089D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        w = sc.nextInt();
        d = sc.nextInt();
        ass = new int[h][w];
        xs = new int[h * w];
        ys = new int[h * w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ass[i][j] = sc.nextInt();
                int index = ass[i][j] - 1;
                xs[index] = j;
                ys[index] = i;
            }
        }
        q = sc.nextInt();
        ls = new int[q];
        rs = new int[q];
        for (int i = 0; i < q; i++) {
            ls[i] = sc.nextInt() - 1;
            rs[i] = sc.nextInt() - 1;
        }
        solve();
    }

    void solve() {
        int maxNum = h * w;
        long[][] dp = new long[d][maxNum / d + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                int x = d * j + i;
                if (x >= maxNum) {
                    continue;
                }
                dp[i][j] = dp[i][j - 1] + Math.abs(xs[x] - xs[x - d]) +
                        Math.abs(ys[x] - ys[x - d]);
            }
        }
        for (int i = 0; i < q; i++) {
            int indexLX = ls[i] / d;
            int indexLY = ls[i] % d;
            int indexRX = rs[i] / d;
            long cost = dp[indexLY][indexRX] - dp[indexLY][indexLX];
            System.out.println(cost);
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
