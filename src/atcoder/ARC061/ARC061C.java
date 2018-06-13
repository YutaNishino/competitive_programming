package atcoder.ARC061;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ARC061C {
    char[] cs;
    long allSum = 0;

    public static void main(String args[]) {
        new ARC061C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        dfs(0, 0, 0);
        System.out.println(allSum);
    }

    void dfs(int pointer, long sum, long rem) {
        if (pointer == cs.length - 1) {
            allSum += sum + Character.getNumericValue(cs[pointer]) + rem * 10;
            return;
        }
        int num = Character.getNumericValue(cs[pointer]);
        dfs(pointer + 1, sum + rem * 10 + num, 0);
        dfs(pointer + 1, sum, rem * 10 + num);
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
