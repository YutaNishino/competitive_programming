package atcoder.ABC027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC027B {
    int n;
    int[] as;

    public static void main(String args[]) {
        new ABC027B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
            sum += as[i];
        }
        if (sum % n != 0) {
            System.out.println(-1);
            return;
        }
        int mean = sum / n;
        int tempSum = 0;
        int count = 0;
        int l = 0;
        for (int i = 0; i < n; i++) {
            tempSum += as[i];
            if (tempSum == mean * (i - l + 1)) {
                tempSum = 0;
                l = i + 1;
            } else {
                count++;
            }
        }
        System.out.println(count);
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
