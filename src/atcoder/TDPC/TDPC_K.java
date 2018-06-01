package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TDPC_K {
    int n;
    Circle[] cs;

    public static void main(String args[]) {
        new TDPC_K().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        cs = new Circle[n];
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int r = sc.nextInt();
            cs[i] = new Circle(x, r);
        }
        solve();
    }

    void solve() {
        Arrays.sort(cs, new Comparator<Circle>() {
            @Override
            public int compare(Circle o1, Circle o2) {
                if (o1.left == o2.left) {
                    return o1.right - o2.right;
                }
                return o1.left - o2.left;
            }
        });
        int[] indexes = new int[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = -cs[i].right;
        }
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            dp[lower_bound(dp, indexes[i])] = indexes[i];
        }
        System.out.println(lower_bound(dp, Integer.MAX_VALUE));
    }

    static int lower_bound(int[] arr, int key) {
        return lower_bound(arr, 0, arr.length - 1, key);
    }

    static int lower_bound(int[] arr, int beginIndex, int endIndex, int key) {
        int low = beginIndex;
        int high = endIndex;
        while (high - low >= 0) {
            int mid = (low + high) / 2;
            if (key <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    static int upper_bound(int[] arr, int key) {
        return upper_bound(arr, 0, arr.length - 1, key);
    }

    static int upper_bound(int[] arr, int beginIndex, int endIndex, int key) {
        int low = beginIndex;
        int high = endIndex;
        while (high - low >= 0) {
            int mid = (low + high) / 2;
            if (key < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    class Circle {
        int left;
        int right;

        Circle(int x, int r) {
            left = x - r;
            right = x + r;
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
