package atcoder.ABC054;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC054B {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] a = new char[n][n];
        char[][] b = new char[m][m];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                a[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < m; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                b[i][j] = str.charAt(j);
            }
        }
        boolean flag = false;
        outer:
        for (int i = 0; i <= n - m; i++) {
            for (int j = 0; j <= n - m; j++) {
                boolean flagTemp = false;
                inner:
                for (int k = 0; k < m; k++) {
                    for (int l = 0; l < m; l++) {
                        if (a[i + k][j + l] != b[k][l]) {
                            break inner;
                        } else if (k == m - 1 && l == m - 1) {
                            flagTemp = true;
                        }
                    }
                }
                if (flagTemp) {
                    flag = true;
                    break outer;
                }
            }
        }
        if (flag) System.out.println("Yes");
        else System.out.println("No");
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
