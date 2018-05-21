package codeforces.Div2_478;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Div2_478A {
    int n;
    String[] ss;

    public static void main(String args[]) {
        new Div2_478A().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        ss = new String[n];
        for (int i = 0; i < n; i++) {
            ss[i] = sc.next();
        }
        solve();
    }

    void solve() {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            String root = getRoot(ss[i]);
            set.add(root);
        }
        System.out.println(set.size());
    }

    String getRoot(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            set.add(c);
        }
        StringBuilder sb = new StringBuilder();
        List<Character> cs = new ArrayList<>();
        for (char c : set) {
            cs.add(c);
        }
        Collections.sort(cs);
        for (char c : cs) {
            sb.append(c);
        }
        return sb.toString();
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
