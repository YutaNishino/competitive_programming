package atcoder.indeed_now_final_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class indeed_now_final_B_D {
    int h, w, sx, sy, gx, gy;
    int[][] pss;

    public static void main(String args[]) {
        new indeed_now_final_B_D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        w = sc.nextInt();
        sx = sc.nextInt() - 1;
        sy = sc.nextInt() - 1;
        gx = sc.nextInt() - 1;
        gy = sc.nextInt() - 1;
        pss = new int[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                pss[i][j] = sc.nextInt();
            }
        }
        solve();
    }

    void solve() {
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < h * w; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                int index = i * w + j;
                if (i > 0) {
                    graph.get(index).add(new Pair(index - w,
                            pss[i][j] * pss[i - 1][j]));
                    graph.get(index - w).add(new Pair(index,
                            pss[i][j] * pss[i - 1][j]));
                }
                if (i < h - 1) {
                    graph.get(index).add(new Pair(index + w,
                            pss[i][j] * pss[i + 1][j]));
                    graph.get(index + w).add(new Pair(index,
                            pss[i][j] * pss[i + 1][j]));
                }
                if (j > 0) {
                    graph.get(index).add(new Pair(index - 1,
                            pss[i][j] * pss[i][j - 1]));
                    graph.get(index - 1).add(new Pair(index,
                            pss[i][j] * pss[i][j - 1]));
                }
                if (j < w - 1) {
                    graph.get(index).add(new Pair(index + 1,
                            pss[i][j] * pss[i][j + 1]));
                    graph.get(index + 1).add(new Pair(index,
                            pss[i][j] * pss[i][j + 1]));
                }
            }
        }
        Prim p = new Prim(graph);
        p.minimumSpanningTree(sy * w + sx);
        long ans = p.mstCost;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                ans += pss[i][j];
            }
        }
        System.out.println(ans);
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
            PriorityQueue<Edge> pQueue = new PriorityQueue<>(Collections.reverseOrder());
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
