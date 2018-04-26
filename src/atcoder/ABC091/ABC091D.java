package atcoder.ABC091;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC091D {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] as = new int[n];
        int[] bs = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bs[i] = sc.nextInt();
        }
        int ans = as[0] + bs[0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int temp = as[i] + bs[j];
                if (i == 0 && j == 0) ans = temp;
                else ans = ans ^ temp;
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
