package atcoder.ARC098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC098C {
    int n;
    char[] cs;

    public static void main(String args[]) {
        new ARC098C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        int[] sumEastL = new int[n];
        if (cs[0] == 'E') {
            sumEastL[0] = 1;
        }
        for (int i = 1; i < n; i++) {
            sumEastL[i] = sumEastL[i - 1] + (cs[i] == 'E' ? 1 : 0);
        }
        int min = 10000000;
        for (int i = 0; i < n; i++) {
            int num = sumEastL[n - 1] - sumEastL[i] + (i > 0 ? i - sumEastL[i - 1] : 0);
            if (min > num) {
                min = num;
            }
        }
        System.out.println(min);
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
