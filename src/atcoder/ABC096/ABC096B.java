package atcoder.ABC096;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABC096B {
    int k;
    int[] as;

    public static void main(String args[]) {
        new ABC096B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        as = new int[3];
        as[0] = sc.nextInt();
        as[1] = sc.nextInt();
        as[2] = sc.nextInt();
        k = sc.nextInt();
        solve();
    }

    void solve() {
        Arrays.sort(as);
        while (k > 0) {
            as[2] *= 2;
            k--;
        }
        System.out.println(as[0] + as[1] + as[2]);
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
