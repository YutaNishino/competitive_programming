package codeforces.Div2_478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Div2_478B {
    long[] as;

    public static void main(String args[]) {
        new Div2_478B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        as = new long[14];
        for (int i = 0; i < 14; i++) {
            as[i] = sc.nextLong();
        }
        solve();
    }

    void solve() {
        long max = 0;
        for (int i = 0; i < 14; i++) {
            long take = as[i];
            long[] copy = as.clone();
            copy[i] = 0;
            int remainder = (int)take % 14;
            int quotient = (int)take / 14;
            for (int j = 0; j < 14; j++) {
                copy[j] += quotient;
            }
            int j = i + 1;
            while (remainder > 0) {
                copy[j++ % 14]++;
                remainder--;
            }
            long score = 0;
            for (int k = 0; k < 14; k++) {
                if (copy[k] % 2 == 0) {
                    score += copy[k];
                }
            }
            if (max < score) {
                max = score;
            }
        }
        System.out.println(max);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
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

        String nextLine() {
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
