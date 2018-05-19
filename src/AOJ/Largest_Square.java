package AOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Largest_Square {
    int h, w;
    int[][] board;

    public static void main(String args[]) {
        new Largest_Square().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        w = sc.nextInt();
        board = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        solve();
    }

    void solve() {
        int[][] dp = new int[h][w];
        for (int i = 0; i < h; i++) {
            dp[i][0] = board[i][0] == 0 ? 1 : 0;
        }
        for (int i = 1; i < w; i++) {
            dp[0][i] = board[0][i] == 0 ? 1 : 0;
        }
        int maxWidth = 0;
        for (int i = 0; i < h; i++) {
            if (dp[i][0] == 1) {
                maxWidth = 1;
                break;
            }
        }
        for (int i = 1; i < w; i++) {
            if (dp[0][i] == 1) {
                maxWidth = 1;
                break;
            }
        }
        for (int i = 1; i < h; i++) {
            for (int j = 1; j < w; j++) {
                if (board[i][j] == 1) {
                    continue;
                }
                int temp = dp[i - 1][j - 1] + 1;
                temp = Math.min(temp, dp[i - 1][j] + 1);
                temp = Math.min(temp, dp[i][j - 1] + 1);
                dp[i][j] = temp;
                maxWidth = Math.max(maxWidth, dp[i][j]);
            }
        }
        System.out.println(maxWidth * maxWidth);
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
