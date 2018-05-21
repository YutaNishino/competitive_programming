package atcoder.ARC088;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class ARC088E {
    char[] cs;

    public static void main(String args[]) {
        new ARC088E().run();
    }

    void run() {
        FastReader sc = new FastReader();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if (!map.containsKey(cs[i])) {
                map.put(cs[i], 1);
            } else {
                map.put(cs[i], map.get(cs[i]) + 1);
            }
        }
        boolean flag = false;
        char odd = '_';
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                if (!flag) {
                    flag = true;
                    odd = entry.getKey();
                } else {
                    System.out.println(-1);
                    return;
                }
            }
        }
        int[] places = new int[cs.length];
        for (int i = 0; i < cs.length; i++) {

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
