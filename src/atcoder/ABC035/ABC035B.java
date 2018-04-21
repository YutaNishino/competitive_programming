package atcoder.ABC035;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC035B {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        String s = sc.next();
        int t = sc.nextInt();
        int manhattan = 0;
        int x = 0;
        int y = 0;
        int questionCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '?') {
                questionCount++;
            } else if (s.charAt(i) == 'L') {
                x--;
            } else if (s.charAt(i) == 'R') {
                x++;
            } else if (s.charAt(i) == 'U') {
                y++;
            } else {
                y--;
            }
        }
        int ans = Math.abs(x) + Math.abs(y);
        if (t == 1) {
            System.out.println(ans + questionCount);
        } else {
            if (questionCount < ans) ans -= questionCount;
            else {
                if ((questionCount - ans) % 2 == 0) ans = 0;
                else ans = 1;
            }
            System.out.println(ans);
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
