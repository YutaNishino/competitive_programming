package atcoder.AGC025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class AGC025C {
    int n;
    Section[] ss;
    boolean[] used;

    public static void main(String args[]) {
        new AGC025C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        ss = new Section[n];
        for (int i = 0; i < n; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            ss[i] = new Section(l, r, i);
        }
        solve();
    }

    void solve() {
        Section[] ls = new Section[n];
        for (int i = 0; i < n; i++) {
            ls[i] = new Section(ss[i].l, ss[i].r, i);
        }
        Section[] rs = new Section[n];
        for (int i = 0; i < n; i++) {
            rs[i] = new Section(ss[i].l, ss[i].r, i);
        }
        Arrays.sort(ls, new Comparator<Section>() {
            @Override
            public int compare(Section o1, Section o2) {
                return o1.l - o2.l;
            }
        });
        Arrays.sort(rs, new Comparator<Section>() {
            @Override
            public int compare(Section o1, Section o2) {
                return o1.r - o2.r;
            }
        });
        used = new boolean[n];
        long ans = 0;
        int ri = n - 1;
        int li = 0;
        int current = 0;
        boolean r = Math.abs(rs[n - 1].r) > Math.abs(ls[n - 1].l);
        for (int i = 0; i < n; i++) {
            if (!r && (i % 2 == 0) || r && (i % 2 == 1)) {
                while (used[rs[ri].index]) {
                    ri--;
                }
                System.out.println(rs[ri].r);
                ans += Math.abs(current - rs[ri].r);
                current = rs[ri].r;
                used[rs[ri].index] = true;
                ri--;
            } else {
                while (used[ls[li].index]) {
                    li++;
                }
                System.out.println(ls[li].l);
                ans += Math.abs(current - ls[li].l);
                current = ls[li].l;
                used[ls[li].index] = true;
                li++;
            }
        }
        ans += Math.abs(current);
        System.out.println(ans);
    }
/*
    long dfs(int turn, int current, int section) {
        if (turn == n) {
            long res = Math.min(Math.abs(current - ls[section] + Math.abs(ls[section])),
                    Math.abs(current - rs[section]) + Math.abs(rs[section]));
            return res;
        }
        long res = 0;
        used[section] = true;
        for (int i = 0; i < n; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;

        }
    }
    */

    class Section {
        int l;
        int r;
        int index;

        public Section(int l, int r, int index) {
            this.l = l;
            this.r = r;
            this.index = index;
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
