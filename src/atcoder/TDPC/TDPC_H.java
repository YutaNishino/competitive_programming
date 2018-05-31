package atcoder.TDPC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class TDPC_H {
    int n, w, c;
    Item[] items;
    int NEGINF = -(1 << 30);

    public static void main(String args[]) {
        new TDPC_H().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        w = sc.nextInt();
        c = sc.nextInt();
        items = new Item[n];
        for (int i = 0; i < n; i++) {
            int weight = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            items[i] = new Item(weight, v, c);
        }
        solve();
    }

    void solve() {
        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                return o1.c - o2.c;
            }
        });
        int[][][] dp = new int[10001][51][51];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j], NEGINF);
            }
        }
        dp[0][0][0] = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int weight = w - items[i].w; weight >= 0; weight--) {
                for (int color = c; color >= 0; color--) {
                    for (int lastC = 0; lastC <= items[i].c; lastC++) {
                        int nextC = color;
                        if (lastC != items[i].c) {
                            nextC++;
                        }
                        if (dp[weight][color][lastC] == NEGINF || nextC > c) {
                            continue;
                        }
                        dp[weight + items[i].w][nextC][items[i].c] =
                                Math.max(dp[weight + items[i].w][nextC][items[i].c],
                                        dp[weight][color][lastC] + items[i].v);
                        ans = Math.max(ans, dp[weight + items[i].w][nextC][items[i].c]);
                    }
                }
            }
        }
        System.out.println(ans);
    }

    class Item {
        int w;
        int v;
        int c;

        public Item(int w, int v, int c) {
            this.w = w;
            this.v = v;
            this.c = c;
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
