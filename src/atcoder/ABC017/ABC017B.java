package atcoder.ABC017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC017B {
    String x;

    public static void main(String args[]) {
        new ABC017B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        x = sc.next();
        solve();
    }

    void solve() {
        boolean flag = true;
        for (int i = 0; i < x.length(); i++) {
            if (x.charAt(i) == 'c') {
                if (x.charAt(++i) != 'h') {
                    flag = false;
                    break;
                }
            } else if (x.charAt(i) != 'o' && x.charAt(i) != 'k'
                    && x.charAt(i) != 'u') {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
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
