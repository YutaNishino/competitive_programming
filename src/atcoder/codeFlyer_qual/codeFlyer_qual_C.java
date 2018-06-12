package atcoder.codeFlyer_qual;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class codeFlyer_qual_C {
    int n, d;
    int[] xs;

    public static void main(String args[]) {
        new codeFlyer_qual_C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        d = sc.nextInt();
        xs = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int i = 0;
        int j = 1;
        long ans = 0;
        while (i < n - 2 && j < n - 1) {
            if (xs[j] - xs[i] > d) {
                i++;
                continue;
            }
            int ki = upper_bound(xs, xs[i] + d);
            int kj = upper_bound(xs, xs[j] + d) - 1;
            System.out.println(i + " " + j + " " + ki + " " + kj);
            if (ki > kj) {
                j++;
                continue;
            }
            ans += kj - ki + 1;
            i++;
        }
        System.out.println(ans);

        /*
        long ans = 0;
        for (int j = 1; j < n - 1; j++) {
            int iMin = lower_bound(xs, xs[j] - d);
            int kMax = upper_bound(xs, xs[j] + d) - 1;
            for (int i = iMin; i < j; i++) {
                int k = upper_bound(xs, xs[i] + d);
                ans += Math.max(0, kMax - k + 1);
            }
        }
        System.out.println(ans);
        */
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
