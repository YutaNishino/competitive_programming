package atcoder.ABC029;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC029C {
    int n;
    char[] cs;

    public static void main(String args[]) {
        new ABC029C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        solve();
    }

    void solve() {
        cs = new char[n];
        dfs(1);
    }

    void dfs(int i) {
        for (int j = 'a'; j < 'd'; j++) {
            cs[i - 1] = (char)j;
            if (i == n) {
                for (int k = 0; k < n; k++) {
                    System.out.print(cs[k]);
                }
                System.out.println();
            } else {
                dfs(i + 1);
            }
            cs[i - 1] = 0;
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
