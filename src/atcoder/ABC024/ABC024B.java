package atcoder.ABC024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC024B {
    int n, t;

    public static void main(String args[]) {
        new ABC024B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        t = sc.nextInt();
        int[] times = new int[1200000];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            times[a]++;
            times[a + t]--;
        }
        int count = 0;
        for (int i = 1; i < times.length; i++) {
            times[i] = times[i - 1] + times[i];
            if (times[i] > 0) {
                count++;
            }
        }
        System.out.println(count);
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
