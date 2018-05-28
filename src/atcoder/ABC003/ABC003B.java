package atcoder.ABC003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ABC003B {
    char[] ss, ts;

    public static void main(String args[]) {
        new ABC003B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        ss = sc.next().toCharArray();
        ts = sc.next().toCharArray();
        solve();
    }

    void solve() {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('t');
        set.add('c');
        set.add('o');
        set.add('d');
        set.add('e');
        set.add('r');
        set.add('@');
        for (int i = 0; i < ss.length; i++) {
            if (ss[i] != '@' && ts[i] != '@' && ss[i] != ts[i]) {
                System.out.println("You will lose");
                return;
            }
            if (ss[i] == '@' && !set.contains(ts[i])) {
                System.out.println("You will lose");
                return;
            }
            if (ts[i] == '@' && !set.contains(ss[i])) {
                System.out.println("You will lose");
                return;
            }
        }
        System.out.println("You can win");
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
