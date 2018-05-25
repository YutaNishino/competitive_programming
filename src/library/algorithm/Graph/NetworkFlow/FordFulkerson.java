package library.algorithm.Graph.NetworkFlow;

import java.util.ArrayList;
import java.util.Arrays;

class FordFulkerson {
    ArrayList<ArrayList<FFEdge>> graph;
    boolean[] used;

    FordFulkerson(int n) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        used = new boolean[n];
        // manually add edges by using addEdge
    }

    FordFulkerson(ArrayList<ArrayList<FFEdge>> graph) {
        this.graph = graph;
        used = new boolean[graph.size()];
    }

    long maximumFlow(int s, int t) {
        long flow = 0;
        while (true) {
            Arrays.fill(used, false);
            long f = dfs(s, t, Long.MAX_VALUE);
            if (f == 0) {
                return flow;
            }
            flow += f;
        }
    }

    void addEdge(int from, int to, int capacity) {
        graph.get(from).add(new FFEdge(to, capacity, graph.get(to).size()));
        graph.get(to).add(new FFEdge(from, 0, graph.get(from).size() - 1));
    }

    long dfs(int v, int t, long f) {
        if (v == t) {
            return f;
        }
        used[v] = true;
        for (FFEdge e : graph.get(v)) {
            if (!used[e.to] && e.capacity > 0) {
                long d = dfs(e.to, t, Math.min(f, e.capacity));
                if (d > 0) {
                    e.capacity -= d;
                    graph.get(e.to).get(e.reverse).capacity += d;
                    return d;
                }
            }
        }
        return 0;
    }
}

class FFEdge {
    int to;
    int capacity;
    int reverse;

    FFEdge(int to, int capacity, int reverse) {
        this.to = to;
        this.capacity = capacity;
        this.reverse = reverse;
    }
}