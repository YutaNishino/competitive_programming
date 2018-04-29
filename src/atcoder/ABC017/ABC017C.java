package atcoder.ABC017;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC017C {
    int n, m;
    int[] ls, rs, ss;

    public static void main(String args[]) {
        new ABC017C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        ls = new int[n];
        rs = new int[n];
        ss = new int[n];
        for (int i = 0; i < n; i++) {
            ls[i] = sc.nextInt() - 1;
            rs[i] = sc.nextInt() - 1;
            ss[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        int[] scores = new int[m + 1];
        for (int i = 0; i < n; i++) {
            scores[ls[i]] += ss[i];
            scores[rs[i] + 1] -= ss[i];
        }
        for (int i = 0; i < m; i++) {
            scores[i + 1] += scores[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ss[i];
        }
        int minScore = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            minScore = Math.min(minScore, scores[i]);
        }
        ans -= minScore;
        System.out.println(ans);
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
