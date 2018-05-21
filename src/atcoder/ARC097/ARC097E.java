package atcoder.ARC097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC097E {
    int n;
    int[] as;
    boolean[] bs;

    public static void main(String args[]) {
        new ARC097E().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new int[n];
        bs = new boolean[n];
        for (int i = 0; i < 2 * n; i++) {
            bs[i] = sc.next().equals("W");
            as[i] = sc.nextInt() - 1;
        }
        solve();
    }

    void solve() {
        int len = 2 * n;
        int swapNum = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if(bs[i] == bs[j] && as[i] > as[j]) {
                    swapNum++;
                }
            }
        }
        long count = 0;
        while (swapNum > 0) {
            for (int i = 0; i < len; i++) {
                if (as[i] < n - 1) {
                    int nextIndex = i + 1;
                    for (; nextIndex < len; nextIndex++) {
                        if (bs[i] == bs[nextIndex] && as[i] > as[nextIndex]) {
                            break;
                        }
                    }
                    if (nextIndex == len) {
                        continue;
                    }
                    count += nextIndex - i;
                    swapNum--;
                    int temp = as[i];
                    for (int j = i; j < nextIndex; j++) {
                        as[j] = as[j + 1];
                        bs[j] = bs[j + 1];
                    }
                    as[nextIndex] = temp;
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
