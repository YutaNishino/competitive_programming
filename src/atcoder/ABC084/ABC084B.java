package atcoder.ABC084;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC084B {
    int a, b;
    char[] cs;

    public static void main(String args[]) {
        new ABC084B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        boolean flag = true;
        for (int i = 0; i < a; i++) {
            if (!Character.isDigit(cs[i])) {
                flag = false;
            }
        }
        if (cs[a] != '-') {
            flag = false;
        }
        for (int i = a + 1; i <= a + b; i++) {
            if (!Character.isDigit(cs[i])) {
                flag = false;
            }
        }
        if (flag) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
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
