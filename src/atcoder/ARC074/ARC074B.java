package atcoder.ARC074;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC074B {
    int h, w;

    public static void main(String args[]) {
        new ARC074B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        h = sc.nextInt();
        w = sc.nextInt();
        for (int i = 0; i <= h + 1; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append('#');
            if (i == 0 || i == h + 1) {
                for (int j = 0; j < w; j++) {
                    sb.append('#');
                }
            } else {
                sb.append(sc.next());
            }
            sb.append('#');
            System.out.println(sb);
        }
        solve();
    }

    void solve() {

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
