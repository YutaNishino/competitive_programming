package atcoder.indeed_now_final_A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class indeed_now_final_A_B {
    int r, c;
    List<List<Pair>> graph;

    public static void main(String args[]) {
        new indeed_now_final_A_B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        r = sc.nextInt();
        c = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < r * c; i++) {
            graph.add(new LinkedList<>());
        }
        int startCell = -1;
        int goalCell = -1;
        for (int i = 0; i < r; i++) {
            char[] cs = sc.next().toCharArray();
            for (int j = 0; j < c; j++) {
                int cellValue = -1;
                if (Character.isDigit(cs[j])) {
                    cellValue = Character.getNumericValue(cs[j]);
                }
                int cellNum = c * i + j;
                if (cs[j] == 's') {
                    startCell = cellNum;
                    cellValue = 0;
                }
                if (cs[j] == 't') {
                    goalCell = cellNum;
                    cellValue = 0;
                }
                if (j > 0) {
                    graph.get(c * i + j - 1).add(new Pair(cellNum, cellValue));
                }
                if (j < c - 1) {
                    graph.get(c * i + j + 1).add(new Pair(cellNum, cellValue));
                }
                if (i % 2 == 0) {
                    if (i > 0) {
                        if (j > 0) {
                            graph.get(c * (i - 1) + j - 1).add(new Pair(cellNum, cellValue));
                        }
                        graph.get(c * (i - 1) + j).add(new Pair(cellNum, cellValue));
                    }
                    if (i < r - 1) {
                        if (j > 0) {
                            graph.get(c * (i + 1) + j - 1).add(new Pair(cellNum, cellValue));
                        }
                        graph.get(c * (i + 1) + j).add(new Pair(cellNum, cellValue));
                    }
                } else {
                    if (j < c - 1) {
                        graph.get(c * (i - 1) + j + 1).add(new Pair(cellNum, cellValue));
                    }
                    graph.get(c * (i - 1) + j).add(new Pair(cellNum, cellValue));
                    if (i < r - 1) {
                        if (j < c - 1) {
                            graph.get(c * (i + 1) + j + 1).add(new Pair(cellNum, cellValue));
                        }
                        graph.get(c * (i + 1) + j).add(new Pair(cellNum, cellValue));
                    }
                }
            }
        }
        Dijkstra d = new Dijkstra(graph);
        d.shortestPath(startCell);
        System.out.println(d.distances[goalCell]);
    }

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
