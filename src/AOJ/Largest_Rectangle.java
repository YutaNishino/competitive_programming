package AOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Largest_Rectangle {
    int h, w;
    int[][] board;

    public static void main(String args[]) {
        new Largest_Rectangle().run();
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
        System.out.println(largestRectangle(board, 1));
    }

    static int largestRectangle(int[][] board, int blocked) {
        int[][] field = new int[board.length][board[0].length];
        for (int i = 0; i < field[0].length; i++) {
            int count = 0;
            for (int j = 0; j < field.length; j++) {
                if (board[j][i] == blocked) {
                    field[j][i] = 0;
                    count = 0;
                } else {
                    field[j][i] = ++count;
                }
            }
        }
        int maximumArea = 0;
        for (int i = 0; i < board.length; i++) {
            Deque<RectPair> stack = new LinkedList<>();
            for (int j = 0; j <= board[0].length; j++) {
                RectPair rp =
                        new RectPair(j < board[0].length ? field[i][j] : 0, j);
                if (stack.isEmpty()) {
                    stack.push(rp);
                } else {
                    if (stack.peek().height < rp.height) {
                        stack.push(rp);
                    } else if (stack.peek().height > rp.height) {
                        int target = j;
                        while (!stack.isEmpty() &&
                                stack.peek().height >= rp.height) {
                            RectPair pre = stack.pop();
                            int area = pre.height * (j - pre.position);
                            maximumArea = Math.max(maximumArea, area);
                            target = pre.position;
                        }
                        rp.position = target;
                        stack.push(rp);
                    }
                }
            }
        }
        return maximumArea;
    }

    static class RectPair {
        int height;
        int position;

        RectPair(int height, int position) {
            this.height = height;
            this.position = position;
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
