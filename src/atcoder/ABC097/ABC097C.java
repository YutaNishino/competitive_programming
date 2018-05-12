package atcoder.ABC097;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class ABC097C {
    String s;
    int k;

    public static void main(String args[]) {
        new ABC097C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        s = sc.next();
        k = sc.nextInt();
        solve();
    }

    void solve() {
        PriorityQueue<String> pQueue = new PriorityQueue<>();
        SortedSet<String> set = new TreeSet<>();
        char[] cs = s.toCharArray();
        SortedSet<Character> setC = new TreeSet<>();
        for (int i = 0; i < cs.length; i++) {
            setC.add(cs[i]);
        }
        for (char c : setC) {
            for (int i = 0; i < s.length(); i++) {
                if (cs[i] != c) {
                    continue;
                }
                for (int j = 1; j <= k; j++) {
                    if (i + j <= s.length()) {
                        set.add(s.substring(i, i + j));
                    }
                }
            }
            if (set.size() >= k) {
                break;
            }
        }
        int count = 1;
        for (String str : set) {
            if (count == k) {
                System.out.println(str);
                break;
            }
            count++;
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
