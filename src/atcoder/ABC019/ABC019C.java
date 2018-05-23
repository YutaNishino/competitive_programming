package atcoder.ABC019;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ABC019C {
    int n, max;
    int[] as;
    Set<Integer> set;

    public static void main(String args[]) {
        new ABC019C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        max = 0;
        as = new int[n];
        set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextInt();
            set.add(as[i]);
            if (max < as[i]) {
                max = as[i];
            }
        }
        solve();
    }

    void solve() {
        for (int i = 0; i < n; i++) {
            if (set.contains(as[i])) {
                int del = as[i] * 2;
                while (del <= max) {
                    if (set.contains(del)) {
                        set.remove(del);
                    }
                    del *= 2;
                }
            }
        }
        System.out.println(set.size());
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
