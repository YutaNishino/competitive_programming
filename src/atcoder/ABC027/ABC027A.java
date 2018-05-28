package atcoder.ABC027;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC027A {
    int l1, l2, l3;

    public static void main(String args[]) {
        new ABC027A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        l1 = sc.nextInt();
        l2 = sc.nextInt();
        l3 = sc.nextInt();
        solve();
    }

    void solve() {
        if (l1 == l2) {
            System.out.println(l3);
        } else if (l1 == l3) {
            System.out.println(l2);
        } else {
            System.out.println(l1);
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
