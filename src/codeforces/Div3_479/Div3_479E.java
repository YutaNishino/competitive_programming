package codeforces.Div3_479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Div3_479E {
    int n, m;
    List<List<Integer>> graph;

    public static void main(String args[]) {
        new Div3_479E().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        solve();
    }

    void solve() {
        boolean[] visited = new boolean[n];
        int count = 0;
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (dfs(i, visited, parent)) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    boolean dfs(int start, boolean[] visited, int[] parent) {
        Stack<Integer> stack = new Stack<>();
        stack.push(start);
        while(!stack.isEmpty()) {
            int current = stack.pop();
            for (int next : graph.get(current)) {
                if (next == start) {
                    parent[start] = current;
                }
                if (visited[next]) {
                    continue;
                }
                visited[next] = true;
                stack.push(next);
                parent[next] = current;
            }
        }
        int current = start;
        while (true) {
            if (graph.get(current).size() != 2) {
                return false;
            }
            if (parent[current] == start) {
                return true;
            }
            current = parent[current];
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
