package library.algorithm.MinimumSpanningTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

class Prim {
    List<List<Pair>> graph;
    List<List<Pair>> mst;
    long mstCost;
    boolean[] visited;

    Prim(List<List<Pair>> graph) {
        this.graph = graph;
        visited = new boolean[graph.size()];
    }

    Prim(int[] froms, int[] tos, long[] costs, int numVertex) {
        graph = new ArrayList<>();
        for (int i = 0; i < numVertex; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < froms.length; i++) {
            graph.get(froms[i]).add(new Pair(tos[i], costs[i]));
            graph.get(tos[i]).add(new Pair(froms[i], costs[i]));
        }
        visited = new boolean[numVertex];
    }

    long minimumSpanningTree(int start) {
        long cost = 0;
        mst = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            mst.add(new LinkedList<>());
        }
        visited[start] = true;
        PriorityQueue<Edge> pQueue = new PriorityQueue<>();
        for (Pair e : graph.get(start)) {
            pQueue.offer(new Edge(start, e.vertex, e.cost));
        }
        while (true) {
            if (pQueue.isEmpty()) {
                break;
            }
            Edge e = pQueue.poll();
            if (visited[e.to]) {
                continue;
            }
            visited[e.to] = true;
            mst.get(e.from).add(new Pair(e.to, e.cost));
            cost += e.cost;
            for (Pair p : graph.get(e.to)) {
                pQueue.offer(new Edge(e.to, p.vertex, p.cost));
            }
        }
        mstCost = cost;
        return cost;
    }
}

class Pair implements Comparable<Pair>{
    int vertex;
    long cost;

    Pair(int vertex, long cost) {
        this.vertex = vertex;
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

class Edge implements Comparable<Edge>{
    int from;
    int to;
    long cost;

    Edge(int from, int to, long cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    public int compareTo(Edge p) {
        if (cost == p.cost) {
            return 0;
        } else {
            return cost < p.cost ? -1 : 1;
        }
    }
}
