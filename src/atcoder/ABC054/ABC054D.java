package atcoder.ABC054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC054D {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int ma = sc.nextInt();
        int mb = sc.nextInt();
        int[][][] dp = new int[41][411][411];
        for(int i = 0; i < 41; i++)
            for (int j = 0; j < 401; j++)
                for (int k = 0; k < 401; k++)
                    dp[i][j][k] = 10000;
        int[] as = new int[n];
        int[] bs = new int[n];
        int[] cs = new int[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
            bs[i] = sc.nextInt();
            cs[i] = sc.nextInt();
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 400; j++) {
                for (int k = 0; k < 400; k++) {
                    dp[i + 1][j + as[i]][k + bs[i]] =
                            Math.min(dp[i + 1][j + as[i]][k + bs[i]],
                            dp[i][j][k] + cs[i]);
                    dp[i + 1][j][k] = Math.min(
                            dp[i + 1][j][k], dp[i][j][k]);
                }
            }
        }
        int ans = 10000;
        for (int i = 1; i < 400; i++) {
            int a = ma * i;
            int b = mb * i;
            if (a > 400 || b > 400) break;
            ans = Math.min(ans, dp[n][a][b]);
        }
        if (ans == 10000) System.out.println(-1);
        else System.out.println(ans);
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
