package atcoder.ABC018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC018A {
    int[] as;

    public static void main(String args[]) {
        new ABC018A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        as = new int[3];
        as[0] = sc.nextInt();
        as[1] = sc.nextInt();
        as[2] = sc.nextInt();
        solve();
    }

    void solve() {
        int[] bs = new int[3];
        if (as[0] > as[1] && as[0] > as[2]) {
            bs[0] = 1;
            if (as[1] > as[2]) {
                bs[1] = 2;
                bs[2] = 3;
            } else {
                bs[1] = 3;
                bs[2] = 2;
            }
        } else if (as[0] < as[1] && as[0] < as[2]) {
            bs[0] = 3;
            if (as[1] > as[2]) {
                bs[1] = 1;
                bs[2] = 2;
            } else {
                bs[1] = 2;
                bs[2] = 1;
            }
        } else {
            bs[0] = 2;
            if (as[1] > as[2]) {
                bs[1] = 1;
                bs[2] = 3;
            } else {
                bs[1] = 3;
                bs[2] = 1;
            }
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(bs[i]);
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
