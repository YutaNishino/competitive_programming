package AOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Maximum_Flow {
    int v, e;

    public static void main(String args[]) {
        new Maximum_Flow().run();
    }

    void run() {
        FastReader sc = new FastReader();
        v = sc.nextInt();
        e = sc.nextInt();
        FordFulkerson ff = new FordFulkerson(v);
        for (int i = 0; i < e; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int capacity = sc.nextInt();
            ff.addEdge(from, to, capacity);
        }
        long ans = ff.maximumFlow(0, v - 1);
        System.out.println(ans);
    }

    class FordFulkerson {
        ArrayList<ArrayList<Edge>> graph;
        boolean[] used;

        FordFulkerson(int n) {
            graph = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                graph.add(new ArrayList<>());
            }
            used = new boolean[n];
            // manually add edges by using addEdge
        }

        FordFulkerson(ArrayList<ArrayList<Edge>> graph) {
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
            graph.get(from).add(new Edge(to, capacity, graph.get(to).size()));
            graph.get(to).add(new Edge(from, 0, graph.get(from).size() - 1));
        }

        long dfs(int v, int t, long f) {
            if (v == t) {
                return f;
            }
            used[v] = true;
            for (Edge e : graph.get(v)) {
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

    class Edge {
        int to;
        int capacity;
        int reverse;

        Edge(int to, int capacity, int reverse) {
            this.to = to;
            this.capacity = capacity;
            this.reverse = reverse;
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
