package atcoder.ABC088;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ABC088D {
    int h, w;
    boolean[][] board;

    public static void main(String args[]) {
        new ABC088D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        w = sc.nextInt();
        board = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            String s = sc.next();
            for (int j = 0; j < w; j++) {
                board[i][j] = s.charAt(j) == '.';
            }
        }
        solve();
    }

    void solve() {
        int[][] distance = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j]) {
                    distance[i][j] = -1;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        distance[0][0] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0));
        while (!queue.isEmpty()) {
            Pair point = queue.poll();
            if (point.x > 0 && distance[point.y][point.x - 1] < 0) {
                distance[point.y][point.x - 1] = distance[point.y][point.x] + 1;
                queue.offer(new Pair(point.x - 1, point.y));
            }
            if (point.x < w - 1 && distance[point.y][point.x + 1] < 0) {
                distance[point.y][point.x + 1] = distance[point.y][point.x] + 1;
                queue.offer(new Pair(point.x + 1, point.y));
            }
            if (point.y > 0 && distance[point.y - 1][point.x] < 0) {
                distance[point.y - 1][point.x] = distance[point.y][point.x] + 1;
                queue.offer(new Pair(point.x, point.y - 1));
            }
            if (point.y < h - 1 && distance[point.y + 1][point.x] < 0) {
                distance[point.y + 1][point.x] = distance[point.y][point.x] + 1;
                queue.offer(new Pair(point.x, point.y + 1));
            }
        }
        if (distance[h - 1][w - 1] < 0) {
            System.out.println(-1);
            return;
        }
        int whiteCount = 0;
        for (int i = 0; i < h; i++){
            for (int j = 0; j < w; j++) {
                if (board[i][j]) {
                    whiteCount++;
                }
            }
        }
        System.out.println(whiteCount - distance[h - 1][w - 1] - 1);
    }

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
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
