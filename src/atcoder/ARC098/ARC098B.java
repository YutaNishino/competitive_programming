package atcoder.ARC098;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ARC098B {
    int n;
    char[] cs;

    public static void main(String args[]) {
        new ARC098B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        cs = sc.next().toCharArray();
        int ans = 0;
        for (int i = 0; i < cs.length - 1; i++) {
            Set<Character> x = new HashSet<>();
            Set<Character> y = new HashSet<>();
            for (int j = 0; j <= i; j++) {
                x.add(cs[j]);
            }
            for (int j = i + 1; j < cs.length; j++) {
                y.add(cs[j]);
            }
            int count = 0;
            for (char c : x) {
                if (y.contains(c)) {
                    count++;
                }
            }
            if (ans < count) {
                ans = count;
            }
        }
        System.out.println(ans);
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
