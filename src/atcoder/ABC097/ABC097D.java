package atcoder.ABC097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC097D {
    int n, m;
    int[] ps, xs, ys;

    public static void main(String args[]) {
        new ABC097D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        ps = new int[n];
        xs = new int[m];
        ys = new int[m];
        for (int i = 0; i < n; i++) {
            ps[i] = sc.nextInt() - 1;
        }
        for (int i = 0; i < m; i++) {
            xs[i] = sc.nextInt() - 1;
            ys[i] = sc.nextInt() - 1;
        }
        solve();
    }

    void solve() {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < m; i++) {
            uf.unite(xs[i], ys[i]);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!uf.differ(i, ps[i])) {
                count++;
            }
        }
        System.out.println(count);
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

}
