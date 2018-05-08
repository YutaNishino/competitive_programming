package atcoder.ABC061;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC061D {
    int n, m;
    List<List<Pair>> graph, reverseGraph;
    boolean[] visited;
    long[] distances;
    boolean[] connected;

    public static void main(String args[]) {
        new ABC061D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        reverseGraph = new ArrayList<>();
        visited = new boolean[n];
        distances = new long[n];
        connected = new boolean[n];
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
            reverseGraph.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            long cost = sc.nextLong();
            graph.get(from).add(new Pair(to, cost));
            reverseGraph.get(to).add(new Pair(from, cost));
        }
        solve();
    }

    void solve() {
        dfs(n - 1);
        List<List<Pair>> connectedGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!connected[i]) {
                connectedGraph.add(new LinkedList<>());
            } else {
                connectedGraph.add(graph.get(i));
            }
        }
        graph = connectedGraph;
        if (bellmanFord(0)) {
            System.out.println(distances[n - 1]);
        } else {
            System.out.println("inf");
        }
    }

    void dfs(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int node = stack.pop();
            connected[node] = true;
            for (Pair neighbor : reverseGraph.get(node)) {
                if (!connected[neighbor.to]) {
                    stack.push(neighbor.to);
                }
            }
        }
    }

    boolean bellmanFord(int start) {
        Arrays.fill(distances, Long.MIN_VALUE);
        distances[start] = 0;
        for (int i = 0; i < graph.size(); i++) {
            boolean update = false;
            for (int j = 0; j < graph.size(); j++) {
                for (Pair neighbor : graph.get(j)) {
                    if (distances[j] != Long.MIN_VALUE &&
                            distances[neighbor.to] < distances[j] + neighbor.cost) {
                        distances[neighbor.to] = distances[j] + neighbor.cost;
                        update = true;
                        if (i == graph.size() - 1) {
                            return false;
                        }
                    }
                }
            }
            if (!update) {
                break;
            }
        }
        return true;
    }

    class Pair implements Comparable<Pair> {
        int to;
        long cost;

        Pair(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Pair p) {
            if (cost == p.cost) {
                return 0;
            } else {
                return cost < p.cost ? -1 : 1;
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
