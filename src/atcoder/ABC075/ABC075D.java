package atcoder.ABC075;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABC075D {
    int n, k;
    int[] xs, ys;

    public static void main(String args[]) {
        new ABC075D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextInt();
        xs = new int[n];
        ys = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
            ys[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int[] xIndexes = xs.clone();
        int[] yIndexes = ys.clone();
        Arrays.sort(xIndexes);
        Arrays.sort(yIndexes);
        long minArea = Long.MAX_VALUE;
        for (int sx = 0; sx < n; sx++) {
            for (int tx = sx; tx < n; tx++) {
                for (int sy = 0; sy < n; sy++) {
                    for (int ty = 0; ty < n; ty++) {
                        int count = 0;
                        for (int i = 0; i < n; i++) {
                            if (xIndexes[sx] <= xs[i] && xs[i] <= xIndexes[tx] &&
                                    yIndexes[sy] <= ys[i] && ys[i] <= yIndexes[ty]) {
                                count++;
                            }
                        }
                        if (count >= k) {
                            long area = ((long)xIndexes[tx] - xIndexes[sx]) *
                                    ((long)yIndexes[ty] - yIndexes[sy]);
                            if (area < minArea) {
                                minArea = area;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(minArea);
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
