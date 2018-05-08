package atcoder.ABC061;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC061C {
    int n;
    long k;
    SortedSet<Integer> set;
    Map<Integer, Long> map;

    public static void main(String args[]) {
        new ABC061C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        k = sc.nextLong();
        set = new TreeSet<>();
        map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            long b = sc.nextInt();
            set.add(a);
            if (map.containsKey(a)) {
                map.put(a, map.get(a) + b);
            } else {
                map.put(a, b);
            }
        }
        solve();
    }

    void solve() {
        long count = 0;
        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            int key = it.next();
            long value = map.get(key);
            long newCount = count + value;
            if (k <= newCount) {
                System.out.println(key);
                return;
            } else {
                count = newCount;
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
