package atcoder.ABC051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC051B {
    int k, s;

    public static void main(String args[]) {
        new ABC051B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        k = sc.nextInt();
        s = sc.nextInt();
        solve();
    }

    void solve() {
        long count = 0;
        for (int x = 0; x <= k; x++) {
            for (int y = 0; y <= k; y++) {
                int z = s - x - y;
                if (z >= 0 && z <= k) {
                    count++;
                }
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
