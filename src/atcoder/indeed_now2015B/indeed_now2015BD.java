package atcoder.indeed_now2015B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class indeed_now2015BD {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        int c = sc.nextInt();
        List<List<Integer>> as = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            as.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            as.get(a - 1).add(i);
        }
        long maxSize = (long)n * (n + 1) / 2;
        for (int i = 0; i < c ; i++) {
            long sub = 0;
            as.get(i).add(0, -1);
            as.get(i).add(n);
            for (int j = 0; j < as.get(i).size() - 1; j++) {
                long len = (as.get(i).get(j + 1) - as.get(i).get(j) - 1);
                sub += len * (len + 1) / 2;
            }
            System.out.println(maxSize - sub);
        }
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
