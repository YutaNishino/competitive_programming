package atcoder.ABC049;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC049C {
    char[] cs;

    public static void main(String args[]) {
        new ABC049C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        cs = sc.next().toCharArray();
        solve();
    }

    void solve() {
        int i = 0;
        boolean flag = true;
        while (i < cs.length) {
            if (checkDream(i)) {
                i += 5;
                continue;
            }
            if (checkDreamer(i)) {
                i += 7;
                continue;
            }
            if (checkErase(i)) {
                i += 5;
                continue;
            }
            if (checkEraser(i)) {
                i += 6;
                continue;
            }
            flag = false;
            break;
        }
        if (flag) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    boolean checkDream(int i) {
        if (cs[i] == 'd') {
            if (i + 4 >= cs.length) {
                return false;
            }
            if (cs[i + 1] != 'r' || cs[i + 2] != 'e' ||
                    cs[i + 3] != 'a' || cs[i + 4] != 'm') {
                return false;
            }
            if (i + 5 == cs.length || cs[i + 5] == 'd' ||
                    checkErase(i + 5) || checkEraser(i + 5)) {
                return true;
            }
        }
        return false;
    }

    boolean checkDreamer(int i) {
        if (cs[i] == 'd') {
            if (i + 6 >= cs.length) {
                return false;
            }
            if (cs[i + 1] != 'r' || cs[i + 2] != 'e' ||
                    cs[i + 3] != 'a' || cs[i + 4] != 'm' ||
                    cs[i + 5] != 'e' || cs[i + 6] != 'r') {
                return false;
            }
            if (i + 7 == cs.length || cs[i + 7] == 'd' || cs[i + 7] == 'e') {
                return true;
            }
        }
        return false;
    }

    boolean checkErase(int i) {
        if (cs[i] == 'e') {
            if (i + 4 >= cs.length) {
                return false;
            }
            if (cs[i + 1] != 'r' || cs[i + 2] != 'a' ||
                    cs[i + 3] != 's' || cs[i + 4] != 'e') {
                return false;
            }
            if (i + 5 == cs.length || cs[i + 5] == 'd' || cs[i + 5] == 'e') {
                return true;
            }
        }
        return false;
    }

    boolean checkEraser(int i) {
        if (cs[i] == 'e') {
            if (i + 5 >= cs.length) {
                return false;
            }
            if (cs[i + 1] != 'r' || cs[i + 2] != 'a' ||
                    cs[i + 3] != 's' || cs[i + 4] != 'e' ||
                    cs[i + 5] != 'r') {
                return false;
            }
            return true;
        }
        return false;
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
