package codeforces.Div2_464;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Div2_464B {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        long n = sc.nextLong();
        int k = sc.nextInt();
        long[] capacities = new long[k];
        for (int i = 0; i < k; i++) {
            capacities[i] = sc.nextLong();
        }
        int typ = 1;
        long rem = n % capacities[0];
        long num = n / capacities[0];
        for (int j = 1; j < k; j++) {
            long candidate = n % capacities[j];
            if (rem > candidate) {
                typ = j + 1;
                rem = candidate;
                num = n / capacities[j];
            }
        }
        System.out.printf("%d %d\n", typ, num);
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
