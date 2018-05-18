package atcoder.ChokudaiSpeedrun001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CSR001J {
    int n;
    int[] as;

    public static void main(String args[]) {
        new CSR001J().run();
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
        FenwickTree ft = new FenwickTree(n);
        long count = 0;
        for (int i = n - 1; i >= 0; i--) {
            count += (long)ft.rangeSum(as[i] - 1);
            ft.update(as[i], 1);
        }
        System.out.println(count);
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
