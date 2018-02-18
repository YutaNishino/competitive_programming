package codeforces.Div2_464;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Div2_464C {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] as = new int[n];
        for (int i = 0; i < n; i++)
            as[i] = sc.nextInt();
        int s = sc.nextInt();
        int f = sc.nextInt();

        int[] cumu = new int[n + 1];
        for (int i = 0; i < n; i++) {
            cumu[i + 1] = cumu[i] + as[i];
        }
        // starts at i-th hour
        int ans = 0;
        int maxNum = 0;
        for (int i = 1; i <= n; i++) {
            int inf = s - i;
            if (inf < 0) inf += n;
            int sup = f - i - 1;
            if (sup < 0) sup += n;
            int num = 0;
            if (inf <= sup) {
                num = cumu[sup + 1] - cumu[inf];
            } else {
                num = cumu[sup + 1] + cumu[n] -  cumu[inf];
            }
            if (maxNum < num) {
                ans = i;
                maxNum = num;
            }
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
