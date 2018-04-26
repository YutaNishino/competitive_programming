package codeforces.Div2_467;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Div2_467B {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int p = sc.nextInt();
        int y = sc.nextInt();
        boolean flag = false;
        long ans = -1;

        for (long i = y; i > p; i--) {
            boolean f = true;
            for (long j = 2; j * j <= i && j <= p; j++) {
                if (i % j == 0) {
                    f = false;
                    break;
                }
            }
            if (f) {
                flag = true;
                ans = i;
                break;
            }
        }

        if (flag) System.out.println(ans);
        else System.out.println(-1);
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
