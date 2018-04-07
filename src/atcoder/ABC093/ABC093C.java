package atcoder.ABC093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC093C {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int min = a;
        int mid = b;
        int max = c;
        if (a > c) {
            if (a > b) {
                max = a;
                if (b > c) {
                    mid = b;
                    min = c;
                } else {
                    mid = c;
                    min = b;
                }
            } else {
                max = b;
                mid = a;
                min = c;
            }
            // a <= c
        } else {
            if (c > b) {
                max = c;
                if (a > b) {
                    mid = a;
                    min = b;
                } else {
                    mid = b;
                    min = a;
                }
            } else {
                max = b;
                mid = c;
                min = a;
            }
        }

        int ans = 0;
        while (mid < max) {
            mid += 2;
            ans++;
        }
        if (mid > max) {
            mid -= 2;
            ans--;
        }
        while (min < max) {
            min += 2;
            ans++;
        }
        if (min > max) {
            min -= 2;
            ans--;
        }

        if (min < max && mid < max) ans++;
        else if (min < max || mid < max) ans += 2;
        System.out.println(ans);
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
