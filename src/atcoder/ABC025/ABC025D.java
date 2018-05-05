package atcoder.ABC025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC025D {
    int[][] board;
    int turn = 0;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new ABC025D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        board = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
                if (board[i][j] > 0) {
                    turn++;
                }
            }
        }
        solve();
    }

    void solve() {
        boolean[] used = new boolean[26];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] > 0) {
                    used[board[i][j]] = true;
                }
            }
        }
        long ans = rec(board, used, turn);
        System.out.println(ans);
    }

    long rec(int[][] board, boolean[] used, int turn) {
        //System.out.println(turn);
        if (!check(board)) {
            return 0;
        }
        if (turn == 25) {
            return 1;
        }
        long ret = 0;
        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == 0) {
                    for (int k = 1; k < used.length; k++) {
                        if (!used[k]) {
                            used[k] = true;
                            board[i][j] = k;
                            ret += rec(board, used, turn + 1);
                            ret %= MOD;
                            used[k] = false;
                            board[i][j] = 0;
                        }
                    }
                    break outer;
                }
            }
        }
        return ret;
    }

    boolean check(int[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] > 0 && board[i][j] < board[i + 1][j] &&
                        board[i + 1][j] < board[i + 2][j]) {
                    return false;
                }
                if (board[i + 2][j] > 0 && board[i][j] > board[i + 1][j] &&
                        board[i + 1][j] > board[i + 2][j]) {
                    return false;
                }
            }
        }
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] > 0 && board[i][j] < board[i][j + 1] &&
                        board[i][j + 1] < board[i][j + 2]) {
                    return false;
                }
                if (board[i][j + 2] > 0 && board[i][j] > board[i][j + 1] &&
                        board[i][j + 1] > board[i][j + 2]) {
                    return false;
                }
            }
        }
        return true;
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
