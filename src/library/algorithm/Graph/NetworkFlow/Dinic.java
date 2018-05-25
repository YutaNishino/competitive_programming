package library.algorithm.Graph.NetworkFlow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Dinic {
    ArrayList<ArrayList<DinicEdge>> graph;
    // distances from s
    int[] levels;
    int[] iters;

    Dinic(int n) {
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        levels = new int[n];
        iters = new int[n];
        // manually add edges by using addEdge
    }

    void bfs(int s) {
        Arrays.fill(levels, -1);
        Queue<Integer> queue = new LinkedList<>();
        levels[s] = 0;
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (DinicEdge e : graph.get(v)) {
                if (e.capacity > 0 && levels[e.to] < 0) {
                    levels[e.to] = levels[v] + 1;
                    queue.offer(e.to);
                }
            }
        }
    }

    long dfs(int v, int t, long f) {
        if (v == t) {
            return f;
        }
        for (int i = iters[v]; i < graph.get(v).size(); i++) {
            DinicEdge e = graph.get(v).get(i);
            if (e.capacity > 0 && levels[v] < levels[e.to]) {
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

    long maximumFlow(int s, int t) {
        long flow = 0;
        while (true) {
            bfs(s);
            if (levels[t] < 0) {
                return flow;
            }
            Arrays.fill(iters, 0);
            long f;
            while ((f = dfs(s, t, Long.MAX_VALUE)) > 0) {
                flow += f;
            }
        }
    }

    void addUndirectedEdge(int from, int to, int capacity) {
        graph.get(from).add(new DinicEdge(to, capacity, graph.get(to).size()));
        graph.get(to).add(new DinicEdge(from, capacity, graph.get(from).size() - 1));
    }

    void addEdge(int from, int to, int capacity) {
        graph.get(from).add(new DinicEdge(to, capacity, graph.get(to).size()));
        graph.get(to).add(new DinicEdge(from, 0, graph.get(from).size() - 1));
    }
}

class DinicEdge {
    int to;
    int capacity;
    int reverse;

    DinicEdge(int to, int capacity, int reverse) {
        this.to = to;
        this.capacity = capacity;
        this.reverse = reverse;
    }
}