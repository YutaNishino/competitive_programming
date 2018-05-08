package atcoder.ABC073;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC073D {
    int n, m, r;
    int[] rs;
    int ans;
    boolean[] visited;
    int[][] distances;
    int INF = 1 << 28;

    public static void main(String args[]) {
        new ABC073D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        r = sc.nextInt();
        rs = new int[r];
        for (int i = 0; i < r; i++) {
            rs[i] = sc.nextInt() - 1;
        }
        solve(sc);
    }

    void solve(FastReader sc) {
        distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) distances[i][j] = INF;
            }
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1 ;
            int cost = sc.nextInt();
            distances[from][to] = cost;
            distances[to][from] = cost;
        }
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distances[i][j] = Math.min(distances[i][j],
                                distances[i][k] + distances[k][j]);
                }
            }
        }
        ans = INF;
        visited = new boolean[r];
        dfs(0, -1, 0);
        System.out.println(ans);
    }

    void dfs(int c, int last, int distance) {
        if (c == r) {
            if (distance < ans) {
                ans = distance;
            }
            return;
        }
        for (int i = 0; i < r; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (last == -1) {
                    dfs(c + 1, i, 0);
                } else {
                    dfs(c + 1, i, distance + distances[rs[last]][rs[i]]);
                }
                visited[i] = false;
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
