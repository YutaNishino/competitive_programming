package codeforces.Div2_464;

import java.io.*;
import java.util.StringTokenizer;

public class Div2_464E {
    public static PrintWriter out;

    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int q = sc.nextInt();
        int one = sc.nextInt();
        int max = sc.nextInt();
        double[] means = new double[q];
        double mean = Integer.valueOf(max).doubleValue();
        means[0] = mean;
        int count = 1;
        for (int i = 1; i < q; i++) {
            int query = sc.nextInt();
            if (query == 1) {
                max = sc.nextInt();
                mean = (mean * count + max) / (count + 1);
                means[count] = mean;
                count++;
            } else if (query == 2) {
                int low = 1;
                int high = count;
                while (low < high) {
                    int mid = (low + high) / 2;
                    double meanMid = max;
                    if (mid > 1) meanMid = (means[mid - 2] * (mid - 1) + max) / mid;
                    if (mid == count) low = mid;
                    else if (meanMid > (means[mid - 1] * mid + max) / (mid + 1)) low = mid + 1;
                    else high = mid;
                }
                double ans = 0.0;
                if (low > 1) ans = max - (means[low - 2] * (low - 1) + max) / low;
                System.out.printf("%6f\n",ans);
            }
        }
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
