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
        String ans = "YES";
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == 'd') {
                if (i + 4 >= cs.length) {
                    ans = "NO";
                    break;
                }
                if (cs[i + 1] != 'r' || cs[i + 2] != 'e' ||
                        cs[i + 3] != 'a' || cs[i + 4] != 'm') {
                    ans = "NO";
                    break;
                }
                if (i + 5 == cs.length || cs[i + 5] == 'd') {
                    continue;
                }
                if (i + 6 >= cs.length) {
                    ans = "NO";
                    break;
                }
                if (cs[i + 5] == 'e' && cs[i + 6] == 'r' && (i + 7 == cs.length ||
                        cs[i + 7] != 'a')) {
                    continue;
                }
                if (cs[i + 5] != 'e' || cs[i + 6] != 'r') {
                    ans = "NO";
                    break;
                }
                i += 6;
            } else if (cs[i] == 'e') {
                if (i + 4 >= cs.length) {
                    ans = "NO";
                    break;
                }
                if (cs[i + 1] != 'r' || cs[i + 2] != 'a' ||
                        cs[i + 3] != 's' || cs[i + 4] != 'e') {
                    ans = "NO";
                    break;
                }
                if (i + 5 == cs.length || cs[i + 5] == 'd' || cs[i + 5] == 'e') {
                    continue;
                }
                if (i + 5 >= cs.length) {
                    ans = "NO";
                    break;
                }
                if (cs[i + 5] != 'r') {
                    ans = "NO";
                    break;
                }
            } else {
                ans = "NO";
                break;
            }
        }
        System.out.println(ans);
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
