package atcoder.ABC047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC047B {
    int w, h, n;
    int[] xs, ys, as;

    public static void main(String args[]) {
        new ABC047B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        w = sc.nextInt();
        h = sc.nextInt();
        n = sc.nextInt();
        xs = new int[n];
        ys = new int[n];
        as = new int[n];
        for (int i = 0; i < n; i++) {
            xs[i] = sc.nextInt();
            ys[i] = sc.nextInt();
            as[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int oneMax = 0;
        int twoMin = w;
        int threeMax = 0;
        int fourMin = h;
        for (int i = 0; i < n; i++) {
            switch (as[i]) {
                case 1:
                    oneMax = Math.max(oneMax, xs[i]);
                    break;
                case 2:
                    twoMin = Math.min(twoMin, xs[i]);
                    break;
                case 3:
                    threeMax = Math.max(threeMax, ys[i]);
                    break;
                default:
                    fourMin = Math.min(fourMin, ys[i]);
                    break;
            }
        }
        System.out.println(Math.max(twoMin - oneMax, 0) *
                Math.max(fourMin - threeMax, 0));
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
