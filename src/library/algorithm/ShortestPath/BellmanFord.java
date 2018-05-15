package library.algorithm.ShortestPath;

import java.util.Arrays;

class BellmanFord {
    Edge[] edges;
    long[] distances;
    long INF = 1L << 60;

    BellmanFord(int[] froms, int[] tos, long[] costs, int numVertex) {
        edges = new Edge[froms.length];
        for (int i = 0; i < froms.length; i++) {
            edges[i] = new Edge(froms[i], tos[i], costs[i]);
        }
        this.distances = new long[numVertex];
        Arrays.fill(this.distances, INF);
    }

    void shortestPath(int start) {
        distances[start] = 0;
        while(true) {
            boolean update = false;
            for (Edge e : edges) {
                if (distances[e.from] < INF) {
                    long newCost = distances[e.from] + e.cost;
                    if (distances[e.to] > newCost) {
                        distances[e.to] = newCost;
                        update = true;
                    }
                }
            }
            if (!update) {
                break;
            }
        }
    }

    class Edge {
        int from;
        int to;
        long cost;

        Edge(int from, int to, long cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }
}
