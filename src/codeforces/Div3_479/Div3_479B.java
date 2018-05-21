package codeforces.Div3_479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Div3_479B {
    int n;
    String s;

    public static void main(String args[]) {
        new Div3_479B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        s = sc.next();
        solve();
    }

    void solve() {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n - 1; i++) {
            String sub = s.substring(i, i + 2);
            if (!map.containsKey(sub)) {
                map.put(sub, 1);
            } else {
                map.put(sub, map.get(sub) + 1);
            }
        }
        int max = 0;
        String maxKey = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > max) {
                max = count;
                maxKey = entry.getKey();
            }
        }
        System.out.println(maxKey);
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
