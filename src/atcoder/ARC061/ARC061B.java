package atcoder.ARC061;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC061B {
    char[] as, bs, cs;

    public static void main(String args[]) {
        new ARC061B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        as = sc.next().toCharArray();
        bs = sc.next().toCharArray();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        int turn = 0;
        int ap = 0, bp = 0, cp = 0;
        while(true) {
            if (turn == 0) {
                if (ap == as.length) {
                    System.out.println('A');
                    return;
                }
                turn = as[ap++] - 'a';
            } else if (turn == 1) {
                if (bp == bs.length) {
                    System.out.println('B');
                    return;
                }
                turn = bs[bp++] - 'a';
            } else {
                if (cp == cs.length) {
                    System.out.println('C');
                    return;
                }
                turn = cs[cp++] - 'a';
            }
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
