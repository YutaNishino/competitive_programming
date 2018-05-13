package atcoder.ABC064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ABC064C {
    int n;
    int[] brackets;

    public static void main(String args[]) {
        new ABC064C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        brackets = new int[9];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if (a < 400) {
                brackets[0]++;
            } else if (a < 800) {
                brackets[1]++;
            } else if (a < 1200) {
                brackets[2]++;
            } else if (a < 1600) {
                brackets[3]++;
            } else if (a < 2000) {
                brackets[4]++;
            } else if (a < 2400) {
                brackets[5]++;
            } else if (a < 2800) {
                brackets[6]++;
            } else if (a < 3200) {
                brackets[7]++;
            } else {
                brackets[8]++;
            }
        }
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if (brackets[i] > 0) {
                count++;
            }
        }
        int min = count;
        if (min == 0) {
            min = 1;
        }
        int max = count + brackets[8];
        System.out.println(min + " " + max);
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
