package atcoder.ABC032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC032C {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int k = sc.nextInt();
        long product = 1;
        long[] series = new long[n];
        boolean zero = false;
        for (int i = 0; i < n; i++) {
            series[i] = sc.nextLong();
            if (series[i] == 0) zero = true;
        }
        if (zero) {
            System.out.println(n);
            return;
        }
        int j = 0;
        int maxLength = 0;
        int length = 0;

        for (int i = 0; j < n; i++) {
            if (j < i) j = i;
            while (j < n) {
                product *= series[j];
                if (product <= k) {
                    length++;
                    j++;
                    if (length > maxLength) maxLength = length;
                } else {
                    product /= series[i];
                    if (i < j) product /= series[j];
                    length--;
                    break;
                }
            }
        }
        System.out.println(maxLength);
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
