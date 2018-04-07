package atcoder.ABC093;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC093A {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        String s = sc.next();
        boolean a = false;
        boolean b = false;
        boolean c = false;
        for (int i = 0; i < 3; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a = true;
            if (ch == 'b') b = true;
            if (ch == 'c') c = true;
        }
        if (a && b && c) System.out.println("Yes");
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
