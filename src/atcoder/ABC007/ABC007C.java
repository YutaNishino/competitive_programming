package atcoder.ABC007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ABC007C {
    int r, c, sy, sx, gy, gx;
    char[][] board;

    public static void main(String args[]) {
        new ABC007C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        r = sc.nextInt();
        c = sc.nextInt();
        sy = sc.nextInt() - 1;
        sx = sc.nextInt() - 1;
        gy = sc.nextInt() - 1;
        gx = sc.nextInt() - 1;
        board = new char[r][c];
        for (int i = 0; i < r; i++) {
            board[i] = sc.next().toCharArray();
        }
        solve();
    }

    void solve() {
        boolean[][] visited = new boolean[r][c];
        Queue<State> queue = new LinkedList<>();
        queue.offer(new State(sy, sx, 0));
        visited[sy][sx] = true;
        while (!queue.isEmpty()) {
            State p = queue.poll();
            if (p.y == gy && p.x == gx) {
                System.out.println(p.distance);
                return;
            }
            if (board[p.y][p.x - 1] != '#' && !visited[p.y][p.x - 1]) {
                queue.offer(new State(p.y, p.x - 1, p.distance + 1));
                visited[p.y][p.x - 1] = true;
            }
            if (board[p.y][p.x + 1] != '#' && !visited[p.y][p.x + 1]) {
                queue.offer(new State(p.y, p.x + 1, p.distance + 1));
                visited[p.y][p.x + 1] = true;
            }
            if (board[p.y - 1][p.x] != '#' && !visited[p.y - 1][p.x]) {
                queue.offer(new State(p.y - 1, p.x, p.distance + 1));
                visited[p.y - 1][p.x] = true;
            }
            if (board[p.y + 1][p.x] != '#' && !visited[p.y + 1][p.x]) {
                queue.offer(new State(p.y + 1, p.x, p.distance + 1));
                visited[p.y + 1][p.x] = true;
            }
        }
    }

    class State {
        int y;
        int x;
        int distance;

        State(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
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
