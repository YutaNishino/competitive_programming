package atcoder.ARC067;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC067B {
    int n;
    char[] cs;

    public static void main(String args[]) {
        new ARC067B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        int x = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == 'I') {
                x++;
                if (max < x) {
                    max = x;
                }
            } else {
                x--;
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
