package atcoder.ABC077;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABC077C {
    int n;
    int[] as, bs, cs;

    public static void main(String args[]) {
        new ABC077C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new int[n];
        bs = new int[n];
        cs = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bs[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            cs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        Arrays.sort(as);
        Arrays.sort(bs);
        Arrays.sort(cs);
        int[] cBoundsForB = new int[n];
        for (int i = 0; i < n; i++) {
            cBoundsForB[i] = lower_bound(cs, bs[i] + 1);
        }
        long[] possibilitiesForB = new long[n];
        if (cBoundsForB[n - 1] < n) {
            possibilitiesForB[n - 1] = n - cBoundsForB[n - 1];
        }
        for (int i = n - 2; i >= 0; i--) {
            possibilitiesForB[i] = n - cBoundsForB[i] + possibilitiesForB[i + 1];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int bBound = lower_bound(bs, as[i] + 1);
            if (bBound < n) {
                ans += possibilitiesForB[bBound];
            }
        }
        System.out.println(ans);
    }

    static int lower_bound(int[] arr, int key) {
        int low = 0;
        int high = arr.length - 1;
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
