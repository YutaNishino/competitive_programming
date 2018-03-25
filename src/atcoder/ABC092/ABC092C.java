package atcoder.ABC092;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC092C {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int[] as = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
        }
        int sum = Math.abs(as[0]);
        for (int i = 1; i < n; i++) {
            sum += Math.abs(as[i] - as[i-1]);
        }
        sum += Math.abs(as[n-1]);
        System.out.println(sum + Math.abs(as[1]) - Math.abs(as[0]) -
                Math.abs(as[0] - as[1]));
        for (int i = 1; i < n-1; i++) {
            int ans = sum + Math.abs(as[i-1] - as[i+1]) -
                    Math.abs(as[i-1] - as[i]) - Math.abs(as[i] - as[i+1]);
            System.out.println(ans);
        }
        System.out.println(sum + Math.abs(as[n-2]) - Math.abs(as[n-1]) -
                Math.abs(as[n-2] - as[n-1]));
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
