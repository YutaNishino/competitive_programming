package codeforces.Div2_466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Div2_466B {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        long n = sc.nextLong();
        long k = sc.nextLong();
        long a = sc.nextLong();
        long b = sc.nextLong();
        long ans = Long.MAX_VALUE;

        if (k == 1) {
            System.out.println(a * (n - 1));
            return;
        }
        long t = 0;
        for (int nb = 0; nb <= 30; nb++) {
            long cost = nb * b + (n - 1 + t) * a;
            ans = Math.min(cost, ans);
            t += n % k;
            n /= k;
        }

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
