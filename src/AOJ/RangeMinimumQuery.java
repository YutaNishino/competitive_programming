package AOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class RangeMinimumQuery {
    int n, q;

    public static void main(String args[]) {
        new RangeMinimumQuery().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        q = sc.nextInt();
        int[] arr = new int[n];
        Arrays.fill(arr, Integer.MAX_VALUE);
        RangeMinQuery rmq = new RangeMinQuery(arr);
        for (int i = 0; i < q; i++) {
            int operation = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (operation == 0) {
                rmq.update_point(x, y);
            } else {
                System.out.println(rmq.query(x, y + 1));
            }
        }
    }

    class RangeMinQuery {
        private final int[] tree;
        private final int N;
        private final int paddedN;
        int MAX = Integer.MAX_VALUE;

        RangeMinQuery(int[] arr) {
            this.N = arr.length;
            int n = 2;
            while (n < arr.length) {
                n <<= 1;
            }
            paddedN = n;
            tree = new int[2 * n - 1];
            int j = 0;
            for (int i = n - 1; i < n - 1 + arr.length; i++, j++) {
                tree[i] = arr[j];
            }
            for (int i = n - 1 + arr.length; i < tree.length; i++) {
                tree[i] = MAX;
            }
            build(0, 0, arr.length, arr);
        }

        void build(int k, int l, int r, int[] arr) {
            if (r - l == 1) {
                tree[k] = arr[l];
            } else {
                int mid = (l + r) >> 1;
                int lChild = (k << 1) + 1;
                int rChild = (k << 1) + 2;
                build(lChild, l, mid, arr);
                build(rChild, mid, r, arr);
                tree[k] = Math.min(tree[lChild], tree[rChild]);
            }
        }

        // returns minimum value from [a, b).
        int query(int a, int b) {
            return query(a, b, 0, 0, paddedN);
        }

        int query(int a, int b, int k, int l, int r) {
            if (r <= a || b <= l) {
                return MAX;
            }
            if (a <= l && r <= b) {
                return tree[k];
            }
            int mid = (l + r) >> 1;
            int lMin = query(a, b, (k << 1) + 1, l, mid);
            int rMin = query(a, b, (k << 1) + 2, mid, r);
            return Math.min(lMin, rMin);
        }

        void update_point(int index, int val) {
            index += paddedN - 1;
            tree[index] = val;
            while (index > 0) {
                index = (index - 1) >> 1;
                tree[index] = Math.min(tree[(index << 1) + 1], tree[(index << 1) + 2]);
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
