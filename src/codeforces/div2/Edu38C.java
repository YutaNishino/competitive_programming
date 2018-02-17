package codeforces.div2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Edu38C {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int x = sc.nextInt();
            long n = 1;
            double pow = 1;
            while(pow < x) {
                n++;
                pow = Math.pow(n, 2);
            }
            boolean flag = false;
            outer:
            do {
                long nOverM = n * n - x;
                long temp = (long)Math.sqrt(nOverM);
                if (temp * temp == nOverM) {
                    long m = findM(n, nOverM);
                    if (m > 0) {
                        System.out.printf("%d %d\n", n, m);
                        flag = true;
                        break outer;
                    }
                }
                n++;
            } while(n <= 1e5);
            if(!flag) System.out.println(-1);
        }
    }

    static long findM(long n, long nOverM) {
        long low = 1;
        long high = n + 1;
        while(low < high) {
            long mid = (low + high) / 2;
            long temp = n / mid;
            if (temp * temp < nOverM) {
                high = mid;
            } else if (temp * temp > nOverM) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
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
