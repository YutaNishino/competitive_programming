package atcoder.ABC067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC067D {
    int n;
    List<List<Integer>> graph;

    public static void main(String args[]) {
        new ABC067D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        solve();
    }

    void solve() {
        int[] black = new int[n];
        int[] white = new int[n];
        Arrays.fill(black, -1);
        Arrays.fill(white, -1);
        black[0] = 0;
        white[n - 1] = 0;
        Queue<Pair> blackQueue = new LinkedList<>();
        Queue<Pair> whiteQueue = new LinkedList<>();
        blackQueue.offer(new Pair(0, 0));
        whiteQueue.offer(new Pair(n - 1, 0));
        while (!blackQueue.isEmpty()) {
            Pair fennec = blackQueue.poll();
            for (int next : graph.get(fennec.node)) {
                if (black[next] == -1) {
                    black[next] = fennec.distance + 1;
                    blackQueue.offer(new Pair(next, fennec.distance + 1));
                }
            }
        }
        while (!whiteQueue.isEmpty()) {
            Pair snuke = whiteQueue.poll();
            for (int next : graph.get(snuke.node)) {
                if (white[next] == -1) {
                    white[next] = snuke.distance + 1;
                    whiteQueue.offer(new Pair(next, snuke.distance + 1));
                }
            }
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (black[i] <= white[i]) {
                count++;
            } else {
                count--;
            }
        }
        if (count > 0) {
            System.out.println("Fennec");
        } else {
            System.out.println("Snuke");
        }
    }

    class Pair {
        int node;
        int distance;

        Pair(int node, int distance) {
            this.node = node;
            this.distance = distance;
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
