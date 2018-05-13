package atcoder.ABC076;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC076C {
    char[] s, t;

    public static void main(String args[]) {
        new ABC076C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        s = sc.next().toCharArray();
        t = sc.next().toCharArray();
        solve();
    }

    void solve() {
        char[] ans = s.clone();
        boolean replaceSub = false;
        for (int i = s.length - 1; i >= 0; i--) {
            boolean flag = true;
            if (i + t.length > s.length) {
                flag = false;
            } else {
                for (int j = i; j < i + t.length; j++) {
                    if (s[j] != t[j - i] && s[j] != '?') {
                        flag = false;
                        break;
                    }
                }
            }
            if (flag) {
                for (int j = i; j < i + t.length; j++) {
                    ans[j] = t[j - i];
                }
                replaceSub = true;
                break;
            }
        }
        if (replaceSub) {
            System.out.println((new String(ans)).replace('?', 'a'));
        } else {
            System.out.println("UNRESTORABLE");
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
