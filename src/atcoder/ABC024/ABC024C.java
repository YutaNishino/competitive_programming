package atcoder.ABC024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC024C {
    int n, d ,k;
    int[] ls, rs;

    public static void main(String args[]) {
        new ABC024C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        ls = new int[d];
        rs = new int[d];
        for (int i = 0; i < d; i++) {
            ls[i] = sc.nextInt();
            rs[i] = sc.nextInt();
        }
        for (int i = 0; i < k; i++) {
            int s = sc.nextInt();
            int t = sc.nextInt();
            for (int j = 0; j < d; j++) {
                if (s - t > 0) {
                    if (ls[j] <= t && rs[j] >= s) {
                        System.out.println(j + 1);
                        break;
                    }
                    if (ls[j] <= s && rs[j] >= s) {
                        s = ls[j];
                    }
                } else {
                    if (ls[j] <= s && rs[j] >= t) {
                        System.out.println(j + 1);
                        break;
                    }
                    if (ls[j] <= s && s <= rs[j]) {
                        s = rs[j];
                    }
                }
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
