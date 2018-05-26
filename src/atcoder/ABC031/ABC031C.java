package atcoder.ABC031;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC031C {
    int n;
    int[] as;

    public static void main(String args[]) {
        new ABC031C().run();
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
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tempTak = Integer.MIN_VALUE;
            int maxAok = Integer.MIN_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                int k = i;
                int l = j;
                if (k > l) {
                    k = j;
                    l = i;
                }
                int tak = 0;
                int aok = 0;
                for (int m = k; m <= l; m++) {
                    if ((m - k) % 2 == 0) {
                        tak += as[m];
                    } else {
                        aok += as[m];
                    }
                }
                if (maxAok < aok) {
                    tempTak = tak;
                    maxAok = aok;
                }
            }
            if (max < tempTak) {
                max = tempTak;
            }
        }
        System.out.println(max);
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
