package atcoder.ABC026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class ABC026C {
    int n;
    List<List<Integer>> graph;

    public static void main(String args[]) {
        new ABC026C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 1; i < n; i++) {
            int b = sc.nextInt() - 1;
            graph.get(b).add(i);
        }
        solve();
    }

    void solve() {
        System.out.println(dfs(0));
    }

    int dfs(int n) {
        if (graph.get(n).size() == 0) {
            return 1;
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int next : graph.get(n)) {
            int res = dfs(next);
            max = Math.max(max, res);
            min = Math.min(min, res);
        }
        return max + min + 1;
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
