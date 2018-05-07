package atcoder.ABC074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC074D {
    int n;
    int[][] distances;

    public static void main(String args[]) {
        new ABC074D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        distances = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distances[i][j] = sc.nextInt();
            }
        }
        solve();
    }

    void solve() {
        long sumDistances = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j) {
                    continue;
                }
                int minDistance = distances[i][j];
                boolean direct = true;
                for (int k = 0; k < n; k++) {
                    if (k == i || k == j) {
                        continue;
                    }
                    int tempMinDistance = distances[i][k] + distances[k][j];
                    if (tempMinDistance < minDistance) {
                        System.out.println(-1);
                        return;
                    }
                    if (tempMinDistance == minDistance) {
                        direct = false;
                    }
                }
                if (direct) {
                    sumDistances += (long)minDistance;
                }
            }
        }
        System.out.println(sumDistances);
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
