package atcoder.ABC049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ABC049D {
    int n, k, l;

    public static void main(String args[]) {
        new ABC049D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        l = sc.nextInt();
        UnionFind road = new UnionFind(n);
        UnionFind rail = new UnionFind(n);
        for (int i = 0; i < k; i++) {
            road.unite(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        for (int i = 0; i < l; i++) {
            rail.unite(sc.nextInt() - 1, sc.nextInt() - 1);
        }
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long l = (long)road.find(i) << 32 | rail.find(i);
            if (!map.containsKey(l)) {
                map.put(l, 1);
            } else {
                map.put(l, map.get(l) + 1);
            }
        }
        for (int i = 0; i < n; i++) {
            long l = (long)road.find(i) << 32 | rail.find(i);
            System.out.print(map.get(l));
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    class Pair {
        int i;
        int j;

        Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    class UnionFind {
        int[] parents;
        // only roots have correct counts
        int[] counts;

        public UnionFind(int size) {
            parents = new int[size];
            counts = new int[size];
            for (int i = 0; i < size; i++) {
                parents[i] = i;
                counts[i] = 1;
            }
        }

        // return the root of the input
        // adopt path compression
        public int find(int a) {
            if (parents[a] == a) return a;
            parents[a] = find(parents[a]);
            return parents[a];
        }

        // adopt weighted union rule
        public void unite(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (counts[a] < counts[b]) {
                parents[a] = b;
                counts[b] += counts[a];
            } else {
                parents[b] = a;
                counts[a] += counts[b];
            }
        }

        public boolean differ(int a, int b) {
            a = find(a);
            b = find(b);
            return a != b;
        }

        public int count(int a) {
            return counts[find(a)];
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
