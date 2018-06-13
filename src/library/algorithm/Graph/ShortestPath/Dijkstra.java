package library.algorithm.Graph.ShortestPath;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Dijkstra {
    List<List<Pair>> graph;
    long[] distances;
    long INF = 1L << 60;

    Dijkstra(List<List<Pair>> graph) {
        this.graph = graph;
        distances = new long[graph.size()];
    }

    void shortestPath(int start) {
        Arrays.fill(distances, INF);
        distances[start] = 0;
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.offer(new Pair(start, 0));
        while (!queue.isEmpty()) {
            Pair node = queue.poll();
            for (Pair neighbor : graph.get(node.vertex)) {
                long newCost = distances[node.vertex] + neighbor.cost;
                if (distances[neighbor.vertex] > newCost) {
                    distances[neighbor.vertex] = newCost;
                    queue.offer(new Pair(neighbor.vertex, newCost));
                }
            }
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
}