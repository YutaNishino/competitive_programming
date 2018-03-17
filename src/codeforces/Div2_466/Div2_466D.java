package codeforces.Div2_466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Div2_466D {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        char[] bs = sc.next().toCharArray();
        int l = -1000000000;
        int r = 1000000000;
        for (int i = 4; i < n; i++) {
            if (bs[i - 4] == '0' && bs[i - 3] == '0' &&
                    bs[i - 2] == '0' && bs[i - 1] == '0' &&
                    bs[i] == '1') {
                int max = Math.max(as[i - 4], as[i - 3]);
                max = Math.max(max, as[i - 2]);
                max = Math.max(max, as[i - 1]);
                max = Math.max(max, as[i]);
                if (l <= max) l = max + 1;
            } else if (bs[i - 4] == '1' && bs[i - 3] == '1' &&
                    bs[i - 2] == '1' && bs[i - 1] == '1' &&
                    bs[i] == '0') {
                int min = Math.min(as[i - 4], as[i - 3]);
                min = Math.min(min, as[i - 2]);
                min = Math.min(min, as[i - 1]);
                min = Math.min(min, as[i]);
                if (min <= r) r = min - 1;
            }
        }
        System.out.printf("%d %d\n", l, r);
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
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

        String nextLine()
        {
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
