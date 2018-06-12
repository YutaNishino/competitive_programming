package atcoder.indeed_now_final_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class indeed_now_final_A_D {
    int n;
    List<List<Pair>> graph;
    int[][] dp;

    int[] upward, downward;

    public static void main(String args[]) {
        new indeed_now_final_A_D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0 ; i < n - 1; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            int type = sc.nextInt();
            if (type == 1) {
                graph.get(from).add(new Pair(to, 1));
                graph.get(to).add(new Pair(from, 2));
            } else {
                graph.get(from).add(new Pair(to, 3));
                graph.get(to).add(new Pair(from, 3));
            }
        }
        solve();
    }

    void solve() {
        dp = new int[2][n];


        upward = new int[n];
        downward = new int[n];
        upward[0] = 0;
        downward[0] = 0;
        System.out.println(dfs(0, -1));
    }

    int dfs(int start, int p) {
        int res = 0;
        for (Pair pa : graph.get(start)) {
            if (pa.vertex == p) {
                continue;
            }
            res = Math.max(res, dfs(pa.vertex, start));

            if (pa.type == 1 || pa.type == 3) {
                res = Math.max(res, dp[0][start] + dp[1][pa.vertex]);
            }
            if (pa.type == 2 || pa.type == 3) {
                res = Math.max(res, dp[1][start] + dp[0][pa.vertex]);
            }
            if (pa.type == 1 || pa.type == 3) {
                dp[1][start] = Math.max(dp[1][start], dp[1][pa.vertex] + 1);
            }
            if (pa.type == 2 || pa.type == 3) {
                dp[0][start] = Math.max(dp[0][start], dp[0][pa.vertex] + 1);
            }
        }
        return res;
    }

    class Pair {
        int vertex;
        int type;

        Pair(int vertex, int type) {
            this.vertex = vertex;
            this.type = type;
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
