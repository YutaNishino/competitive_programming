package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class TDPC_N {
    int n;
    int[] xs;
    int[] ys;
    int MOD = 1000000007;
    Combination c;

    public static void main(String args[]) {
        new TDPC_N().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        xs = new int[n - 1];
        ys = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            xs[i] = sc.nextInt() - 1;
            ys[i] = sc.nextInt() - 1;
        }
        solve();
    }

    void solve() {
        c = new Combination(1000, MOD);
        long ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int root = xs[i];
            int contracted = ys[i];
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                graph.add(new LinkedList<>());
            }
            for (int j = 0; j < n - 1; j++) {
                if (i == j) {
                    continue;
                }
                if (xs[j] == contracted) {
                    graph.get(root).add(ys[j]);
                    graph.get(ys[j]).add(root);
                } else if (ys[j] == contracted) {
                    graph.get(root).add(xs[j]);
                    graph.get(xs[j]).add(root);
                } else {
                    graph.get(xs[j]).add(ys[j]);
                    graph.get(ys[j]).add(xs[j]);
                }
            }
            ans += dfs(root, -1, graph).combination;
            ans %= MOD;
        }
        System.out.println(ans);
    }

    Pair dfs(int root, int p, List<List<Integer>> graph) {
        if (p != -1 && graph.get(root).size() == 1) {
            return new Pair(1,1);
        }
        List<Pair> list = new ArrayList<>();
        long ret = 1;
        int sum = 0;
        for (int next : graph.get(root)) {
            if (next == p) {
                continue;
            }
            Pair temp = dfs(next, root, graph);
            list.add(temp);
            sum += temp.size;
        }
        int subSum = sum;
        for (Pair pair : list) {
            ret *= c.comb(subSum, pair.size) * pair.combination % MOD;
            ret %= MOD;
            subSum -= pair.size;
        }
        return new Pair(sum + 1, ret);
    }

    class Pair {
        int size;
        long combination;

        public Pair(int size, long combination) {
            this.size = size;
            this.combination = combination;
        }
    }

    class Combination {
        long mod;
        int[] facts;
        int[] invs;
        int[] invFacts;

        public Combination(int max, int mod) {
            this.mod = mod;
            facts = new int[max + 2];
            invs = new int[max + 2];
            invFacts = new int[max + 2];
            invs[1] = 1;
            for (int i = 2; i <= max + 1; i++) {
                invs[i] = (int)((long)invs[mod % i] * (mod - mod / i) % mod);
            }
            facts[0] = 1;
            invFacts[0] = 1;
            for (int i = 1; i <= max + 1; i++) {
                facts[i] = (int)(facts[i - 1] * (long)i % mod);
                invFacts[i] = (int)(invFacts[i - 1] * (long)invs[i] % mod);
            }
        }

        long comb (int n, int k) {
            if (k < 0 || k > n) return 0;
            return facts[n] * (long)invFacts[k] % mod * (long)invFacts[n - k] % mod;
        }

        long combRep(int n, int k) {
            return comb(n + k - 1, k);

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
