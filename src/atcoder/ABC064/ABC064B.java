package atcoder.ABC064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC064B {
    int n;

    public static void main(String args[]) {
        new ABC064B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        int max = 0;
        int min = 1000;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (max < a) {
                max = a;
            }
            if (a < min) {
                min = a;
            }
        }
        System.out.println(max - min);
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
