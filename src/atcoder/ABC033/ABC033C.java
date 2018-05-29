package atcoder.ABC033;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC033C {
    char[] cs;

    public static void main(String args[]) {
        new ABC033C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        cs = (sc.next() + "+").toCharArray();
        solve();
    }

    void solve() {
        boolean tempEval = false;
        int state = 0;
        int count = 0;
        for (int i = 0; i < cs.length; i++) {
            if (state == 0) {
                tempEval |= Character.getNumericValue(cs[i]) == 0;
                state = 1;
            } else if (state == 1) {
                if (cs[i] == '*') {
                    state = 2;
                } else {
                    if (!tempEval) {
                        count++;
                    }
                    tempEval = false;
                    state = 0;
                }
            } else {
                tempEval |= Character.getNumericValue(cs[i]) == 0;
                state = 1;
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
