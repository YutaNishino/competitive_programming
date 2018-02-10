package atcoder.ABC054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;

public class ABC054C {
    static int n;
    static boolean[] visited;
    static ArrayList<LinkedList<Integer>> graph;
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        int m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new LinkedList<>());
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        visited = new boolean[n];
        visited[0] = true;
        int ans = dfs(0, 0);
        System.out.println(ans);
    }

    // called as dfs(0, 0)
    static int dfs(int vertex, int length) {
        // base case
        if (length == n - 1) {
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag) return 1;
            else return 0;
        }

        int ans = 0;
        for (int edge : graph.get(vertex)) {
            if (visited[edge]) continue;
            visited[edge] = true;
            ans += dfs(edge, length + 1);
            visited[edge] = false;
        }
        return ans;
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
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

        String nextLine()
        {
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
