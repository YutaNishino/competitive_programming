package atcoder.ARC079;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ARC079F {
    int n;
    int[] ps;

    public static void main(String args[]) {
        new ARC079F().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        ps = new int[n];
        for (int i = 0; i < n; i++) {
            ps[i] = sc.nextInt();
        }
        solve();
    }

    void solve() {
        boolean[] visited = new boolean[n];
        List<Integer> cycle = new ArrayList<>();
        visited[0] = true;
        int j = 0;
        while(!visited[ps[j]]) {
            j = ps[j];
            visited[j] = true;
        }
        cycle.add(ps[j]);
        j = ps[j];
        int k = j;
        while (k != ps[j]) {
            cycle.add(ps[j]);
            j = ps[j];
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
