package atcoder.ABC065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC065D {
    int n;
    int[] xs;
    int[] ys;

    public static void main(String args[]) {
        new ABC065D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        xs = new int[n];
        ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt() - 1;
            ys[i] = sc.nextInt() - 1;
        }
        solve();
    }

    void solve() {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        Integer[] xIndexes = new Integer[n];
        Integer[] yIndexes = new Integer[n];
        for (int i = 0; i < n; i++) {
            xIndexes[i] = i;
            yIndexes[i] = i;
        }
        Arrays.sort(xIndexes, (i, j) -> xs[i] - xs[j]);
        Arrays.sort(yIndexes, (i, j) -> ys[i] - ys[j]);
        for (int i = 0; i < n - 1; i++) {
            graph.get(xIndexes[i]).add(new Pair(xIndexes[i + 1],
                    Math.abs(xs[xIndexes[i]] - xs[xIndexes[i + 1]])));
            graph.get(xIndexes[i + 1]).add(new Pair(xIndexes[i],
                    Math.abs(xs[xIndexes[i]] - xs[xIndexes[i + 1]])));
            graph.get(yIndexes[i]).add(new Pair(yIndexes[i + 1],
                    Math.abs(ys[yIndexes[i]] - ys[yIndexes[i + 1]])));
            graph.get(yIndexes[i + 1]).add(new Pair(yIndexes[i],
                    Math.abs(ys[yIndexes[i]] - ys[yIndexes[i + 1]])));
        }
        Prim p = new Prim(graph);
        System.out.println(p.minimumSpanningTree(0));
    }

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
