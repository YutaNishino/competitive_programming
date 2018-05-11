package atcoder.ABC075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABC075C {
    int n, m;
    int[] as, bs;

    public static void main(String args[]) {
        new ABC075C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        as = new int[m];
        bs = new int[m];
        for (int i = 0; i < m; i++) {
            as[i] = sc.nextInt() - 1;
            bs[i] = sc.nextInt() - 1;
        }
        solve();
    }

    void solve() {
        int count = 0;
        for (int i = 0; i < m; i++) {
            UnionFind uf = new UnionFind(n);
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    continue;
                }
                uf.unite(as[j], bs[j]);
            }
            for (int j = 1; j < n; j++) {
                if (uf.differ(0, j)) {
                    count++;
                    break;
                }
            }
        }
        System.out.println(count);

    }

    class UnionFind {
        int[] parent;
        // only roots have correct counts
        int[] count;

        public UnionFind(int size) {
            parent = new int[size];
            count = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                count[i] = 1;
            }
        }

        // return the root of the input
        // adopt path compression
        public int find(int a) {
            if (parent[a] == a) return a;
            parent[a] = find(parent[a]);
            return parent[a];
        }

        // adopt weighted union rule
        public void unite(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (count[a] < count[b]) {
                parent[a] = b;
                count[b] += count[a];
            } else {
                parent[b] = a;
                count[a] += count[b];
            }
        }

        public boolean differ(int a, int b) {
            a = find(a);
            b = find(b);
            return a != b;
        }

        public int count(int a) {
            return count[find(a)];
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
