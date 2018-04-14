package atcoder.ABC094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC094D {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        List<Integer> as = new ArrayList<>();
        for (int i = 0; i < n; i++) as.add(sc.nextInt());
        int max = Collections.max(as);
        List<Double> bs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bs.add(Math.abs(1.0 * max / 2 - as.get(i)));
        }
        double min = Double.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < n; i++) {
            if (bs.get(i) < min && as.get(i) != max) {
                min = bs.get(i);
                minIndex = i;
            }
        }
        System.out.printf("%d %d\n", max, as.get(minIndex));
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
