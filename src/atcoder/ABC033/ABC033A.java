package atcoder.ABC033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ABC033A {
    Set<Character> set;

    public static void main(String args[]) {
        new ABC033A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        set = new HashSet<>();
        char[] cs = sc.next().toCharArray();
        for (int i = 0; i < cs.length; i++) {
            set.add(cs[i]);
        }
        if (set.size() != 1) {
            System.out.println("DIFFERENT");
        } else {
            System.out.println("SAME");
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
