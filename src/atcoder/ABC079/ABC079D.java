package atcoder.ABC079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC079D {
    int h, w;
    long[][] distances;
    int[][] board;

    public static void main(String args[]) {
        new ABC079D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        w = sc.nextInt();
        distances = new long[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                distances[i][j] = sc.nextLong();
            }
        }
        board = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                board[i][j] = sc.nextInt();
            }
        }
        solve();
    }

    void solve() {
        WarshallFloyd wf = new WarshallFloyd(distances);
        wf.shortestPath();
        long ans = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == -1) {
                    continue;
                }
                ans += wf.distances[board[i][j]][1];
            }
        }
        System.out.println(ans);
    }

    public class WarshallFloyd {
        long[][] distances;
        int numVertexes;
        int[][] successors;
        long INF = 1 << 60;

        WarshallFloyd(long[][] distances) {
            this.distances = distances;
            numVertexes = distances.length;
        }

        WarshallFloyd(long[][] distances, int[][] successors) {
            this.distances = distances;
            numVertexes = distances.length;
            this.successors = successors;
        }

        void shortestPath() {
            for (int k = 0; k < numVertexes; k++) {
                for (int i = 0; i < numVertexes; i++) {
                    for (int j = 0; j < numVertexes; j++) {
                        distances[i][j] = Math.min(distances[i][j],
                                distances[i][k] + distances[k][j]);
                    }
                }
            }
        }

        void shortestPathWithPath() {
            for (int k = 0; k < numVertexes; k++) {
                for (int i = 0; i < numVertexes; i++) {
                    for (int j = 0; j < numVertexes; j++) {
                        long newDistance = distances[i][k] + distances[k][j];
                        if (distances[i][j] > newDistance) {
                            distances[i][j] = newDistance;
                            successors[i][j] = successors[i][k];
                        }
                    }
                }
            }
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
