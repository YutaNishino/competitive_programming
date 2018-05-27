package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TDPC_B {
    int a, b;
    int[] as, bs;
    int[][] memo1, memo2;

    public static void main(String args[]) {
        new TDPC_B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        as = new int[a];
        bs = new int[b];
        for (int i = 0; i < a; i++) {
            as[i] = sc.nextInt();
        }
        for (int i = 0; i < b; i++) {
            bs[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        memo1 = new int[1001][1001];
        for (int i = 0; i < memo1.length; i++) {
            Arrays.fill(memo1[i], -1);
        }
        System.out.println(dfs(0, a, b));
    }

    int dfs(int turn, int aRem, int bRem) {
        //System.out.println(turn + " " + aRem + " " + bRem);
        if (memo1[aRem][bRem] >= 0) {
            return memo1[aRem][bRem];
        }
        if (aRem == 0 && bRem == 1) {
            if (turn % 2 == 0) {
                memo1[aRem][bRem] = bs[b - 1];
            } else {
                memo1[aRem][bRem] = 0;
            }
            return memo1[aRem][bRem];
        }
        if (aRem == 1 && bRem == 0) {
            if (turn % 2 == 0) {
                memo1[aRem][bRem] = as[a - 1];
            } else {
                memo1[aRem][bRem] = 0;
            }
            return memo1[aRem][bRem];
        }
        int score;
        if (turn % 2 == 0) {
            score = Math.max((aRem > 0 ? as[a - aRem] + dfs(turn + 1, aRem - 1, bRem) : 0),
                    (bRem > 0 ? bs[b - bRem] + dfs(turn + 1, aRem, bRem - 1) : 0));
        } else {
            score = Math.min((aRem > 0 ? dfs(turn + 1, aRem - 1, bRem) : Integer.MAX_VALUE),
                    (bRem > 0 ? dfs(turn + 1, aRem, bRem - 1) : Integer.MAX_VALUE));
        }
        memo1[aRem][bRem] = score;
        //System.out.println(turn + " " + aRem + " " + bRem + " " + score);
        return score;
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
