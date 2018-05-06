package atcoder.ABC057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABC057D {
    int n, a, b;
    double[] vs;
    double precision = 10e-6;

    public static void main(String args[]) {
        new ABC057D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        a = sc.nextInt();
        b = sc.nextInt();
        vs = new double[n];
        for (int i = 0; i < n; i++) {
            vs[i] = sc.nextDouble();
        }
        solve();
    }

    void solve() {
        boolean[] maximums = new boolean[n];
        Arrays.sort(vs);
        double sum = 0.0;
        for (int i = n - 1; i >= n - a; i--) {
            sum += vs[i];
        }
        double maxAverage = sum / a;
        double minInAverage = vs[n - a];
        System.out.printf("%6f\n", maxAverage);

        int minCount = 0;
        int index;
        for (index = 0; index < n; index++) {
            if (Math.abs(vs[index] - minInAverage) < precision) {
                minCount++;
            }
            if (vs[index] > minInAverage &&
                    Math.abs(vs[index] - minInAverage) > precision) {
                break;
            }
        }
        int minNum = index - n + a;
        if (minInAverage < maxAverage &&
                Math.abs(minInAverage - maxAverage) > precision) {
            System.out.println(combination(minCount, minNum));
        } else {
            long ans = 0;
            for (int i = minNum; i <= index - n + b; i++) {
                ans += combination(minCount, i);
            }
            System.out.println(ans);
        }
    }

    long combination(int n, int k) {
        long ret = 1;
        for (long i = 1; i <= k; i++) {
            ret *= n + 1 - i;
            ret /= i;
        }
        return ret;
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
