package atcoder.ChokudaiSpeedrun001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CSR001K {
    int n;
    int[] as;
    int MOD = 1000000007;

    public static void main(String args[]) {
        new CSR001K().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        long num = 1;
        long[] factorial = fillFactorial(n, MOD);
        FenwickTree ft = new FenwickTree(n);
        for (int i = 0; i < n; i++) {
            int sub = ft.rangeSum(as[i] - 1);
            ft.update(as[i], 1);
            num += ((long)as[i] - 1 - sub) * factorial[n - i - 1];
            num %= MOD;
        }
        System.out.println(num);
    }

    long[] fillFactorial(int max, int mod) {
        long[] facts = new long[max + 1];
        facts[0] = 1;
        for (int i = 1; i < facts.length; i++) {
            facts[i] = facts[i - 1] * i % mod;
        }
        return facts;
    }

    class FenwickTree {
        private final int[] tree;
        private final int N;

        FenwickTree(int N){
            this.tree = new int[N + 1];
            this.N = N;
        }

        private int lsb(int x){
            return x & (-x);
        }

        void update(int position, int key){
            while (position <= N){
                tree[position] += key;
                position += lsb(position);
            }
        }

        int rangeSum(int position){
            int sum = 0;

            while (position >= 1){
                sum += tree[position];
                position -= lsb(position);
            }

            return sum;
        }

        int rangeSum(int x, int y){
            return rangeSum(y) - rangeSum(x - 1);
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
