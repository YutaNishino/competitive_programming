package atcoder.indeed_now2015A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class indeed_now2015AD {
    int h, w;
    int[][] board;
    int maxDistance = 24;

    public static void main(String args[]) {
        new indeed_now2015AD().run();
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
        Map<int[][], Integer> costs = new HashMap<>();
        PriorityQueue<State> pQueue = new PriorityQueue<>();
        costs.put(board, 0);
        int startY = -1;
        int startX = -1;
        outer:
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 0) {
                    startY = i;
                    startX = j;
                    break outer;
                }
            }
        }
        pQueue.offer(new State(board, 0, 0, 0, startY, startX, -1, -1));
        while (!pQueue.isEmpty()) {
            State s = pQueue.poll();
            if (estimateCost(s.board) == 0) {
                System.out.println(s.distance);
                return;
            }
            int newDistance = s.distance + 1;
            if (newDistance > maxDistance) {
                continue;
            }
            if (s.x > 0 && s.parentX != s.x - 1) {
                int newX = s.x - 1;
                int[][] newBoard = copy(s.board);
                int temp = newBoard[s.y][s.x];
                newBoard[s.y][s.x] = newBoard[s.y][newX];
                newBoard[s.y][newX] = temp;
                int estimatedCost = estimateCost(newBoard);
                int newCost = newDistance + estimatedCost;
                if (!costs.containsKey(newBoard) ||
                        costs.get(newBoard) > newCost) {
                    costs.put(newBoard, newCost);
                    pQueue.offer(new State(newBoard, newCost, newDistance,
                            estimatedCost, s.y, newX, s.y, s.x));
                }
            }
            if (s.x < w - 1 && s.parentX != s.x + 1) {
                int newX = s.x + 1;
                int[][] newBoard = copy(s.board);
                int temp = newBoard[s.y][s.x];
                newBoard[s.y][s.x] = newBoard[s.y][newX];
                newBoard[s.y][newX] = temp;
                int estimatedCost = estimateCost(newBoard);
                int newCost = newDistance + estimatedCost;
                if (!costs.containsKey(newBoard) ||
                        costs.get(newBoard) > newCost) {
                    costs.put(newBoard, newCost);
                    pQueue.offer(new State(newBoard, newCost, newDistance,
                            estimatedCost, s.y, newX, s.y, s.x));
                }
            }
            if (s.y > 0 && s.parentY != s.y - 1) {
                int newY = s.y - 1;
                int[][] newBoard = copy(s.board);
                int temp = newBoard[s.y][s.x];
                newBoard[s.y][s.x] = newBoard[newY][s.x];
                newBoard[newY][s.x] = temp;
                int estimatedCost = estimateCost(newBoard);
                int newCost = newDistance + estimatedCost;
                if (!costs.containsKey(newBoard) ||
                        costs.get(newBoard) > newCost) {
                    costs.put(newBoard, newCost);
                    pQueue.offer(new State(newBoard, newCost, newDistance,
                            estimatedCost, newY, s.x, s.y, s.x));
                }
            }
            if (s.y < h - 1 && s.parentY != s.y + 1) {
                int newY = s.y + 1;
                int[][] newBoard = copy(s.board);
                int temp = newBoard[s.y][s.x];
                newBoard[s.y][s.x] = newBoard[newY][s.x];
                newBoard[newY][s.x] = temp;
                int estimatedCost = estimateCost(newBoard);
                int newCost = newDistance + estimatedCost;
                if (!costs.containsKey(newBoard) ||
                        costs.get(newBoard) > newCost) {
                    costs.put(newBoard, newCost);
                    pQueue.offer(new State(newBoard, newCost, newDistance,
                            estimatedCost, newY, s.x, s.y, s.x));
                }
            }
        }
    }

    int[][] copy(int[][] board) {
        int[][] ret = new int[board.length][board[0].length];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                ret[i][j] = board[i][j];
            }
        }
        return ret;
    }

    int estimateCost(int[][] board) {
        int estimatedCost = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 0) {
                    continue;
                }
                int num = board[i][j]- 1;
                int y = num / w;
                int x = num % w;
                estimatedCost += Math.abs(i - y) + Math.abs(j - x);
            }
        }
        return estimatedCost;
    }

    class State implements Comparable<State> {
        int[][] board;
        int cost;
        int distance;
        int estimatedCost;
        int y;
        int x;
        int parentY;
        int parentX;

        State(int[][] board, int cost, int distance, int estimatedCost,
              int y, int x, int parentY, int parentX) {
            this.board = board;
            this.cost = cost;
            this.distance = distance;
            this.estimatedCost = estimatedCost;
            this.y = y;
            this.x = x;
            this.parentY = parentY;
            this.parentX = parentX;
        }

        public int compareTo(State s) {
            return this.cost - s.cost;
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
