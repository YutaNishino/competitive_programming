package atcoder.ARC069;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ARC069D {
    int n;
    int[] s;

    public static void main(String args[]) {
        new ARC069D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        char[] cs = sc.next().toCharArray();
        s = new int[n + 1];
        for (int i = 0; i < n; i++) {
            s[i] = cs[i] == 'o' ? 1 : 0;
        }
        s[n] = s[0];
        solve();
    }

    void solve() {
        // n: sheep, 1: sheep
        boolean[] ss = new boolean[n + 2];
        ss[0] = true;
        ss[1] = true;
        for (int i = 2; i <= n + 1; i++) {
            if (ss[i - 1] && s[i - 2] == 1 || !ss[i - 1] && s[i - 2] == 0) {
                ss[i] = ss[i - 2];
            } else {
                ss[i] = !ss[i - 2];
            }
        }
        if (ss[n] == ss[0] && ss[n + 1] == ss[1]) {
            for (int i = 1; i <= n; i++) {
                System.out.print(ss[i] ? 'S' : 'W');
            }
            System.out.println();
            return;
        }
        // n: sheep, 1: wolf
        Arrays.fill(ss, false);
        ss[0] = true;
        ss[1] = false;
        for (int i = 2; i <= n + 1; i++) {
            if (ss[i - 1] && s[i - 2] == 1 || !ss[i - 1] && s[i - 2] == 0) {
                ss[i] = ss[i - 2];
            } else {
                ss[i] = !ss[i - 2];
            }
        }
        if (ss[n] == ss[0] && ss[n + 1] == ss[1]) {
            for (int i = 1; i <= n; i++) {
                System.out.print(ss[i] ? 'S' : 'W');
            }
            System.out.println();
            return;
        }
        // n: wolf, 1: sheep
        Arrays.fill(ss, false);
        ss[0] = false;
        ss[1] = true;
        for (int i = 2; i <= n + 1; i++) {
            if (ss[i - 1] && s[i - 2] == 1 || !ss[i - 1] && s[i - 2] == 0) {
                ss[i] = ss[i - 2];
            } else {
                ss[i] = !ss[i - 2];
            }
        }
        if (ss[n] == ss[0] && ss[n + 1] == ss[1]) {
            for (int i = 1; i <= n; i++) {
                System.out.print(ss[i] ? 'S' : 'W');
            }
            System.out.println();
            return;
        }
        // n: wolf, 1: wolf
        Arrays.fill(ss, false);
        ss[0] = false;
        ss[1] = false;
        for (int i = 2; i <= n + 1; i++) {
            if (ss[i - 1] && s[i - 2] == 1 || !ss[i - 1] && s[i - 2] == 0) {
                ss[i] = ss[i - 2];
            } else {
                ss[i] = !ss[i - 2];
            }
        }
        if (ss[n] == ss[0] && ss[n + 1] == ss[1]) {
            for (int i = 1; i <= n; i++) {
                System.out.print(ss[i] ? 'S' : 'W');
            }
            System.out.println();
            return;
        }
        System.out.println(-1);
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
