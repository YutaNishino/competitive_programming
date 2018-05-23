package atcoder.ABC018;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC018B {
    char[] cs;
    int n;

    public static void main(String args[]) {
        new ABC018B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        cs = sc.next().toCharArray();
        n = sc.nextInt();
        int[] indexes = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {
            indexes[i] = i;
        }
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            int toIndex = r;
            int fromIndex = l;
            while (fromIndex < toIndex) {
                int temp = indexes[fromIndex];
                indexes[fromIndex] = indexes[toIndex];
                indexes[toIndex] = temp;
                fromIndex++;
                toIndex--;
            }
        }
        for (int i = 0; i < cs.length; i++) {
            System.out.print(cs[indexes[i]]);
        }
        System.out.println();
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
