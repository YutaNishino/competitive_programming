package atcoder.indeed_now2015B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class indeed_now2015BB {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        StringBuilder s = new StringBuilder(sc.next());
        StringBuilder t = new StringBuilder(sc.next());

        if (s.length() != t.length()) {
            System.out.println(-1);
            return;
        }
        int count = 0;
        boolean done = false;
        while (count <= s.length()) {
            if (s.length() == t.length()) {
                boolean flag = true;
                for (int i = 0; i < s.length(); i++) {
                    if (s.charAt(i) != t.charAt(i)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    done = true;
                    break;
                }
            }
            char c = s.charAt(s.length() - 1);
            s.deleteCharAt(s.length() - 1);
            s.insert(0, c);
            count++;
        }
        if (!done) count = -1;
        System.out.println(count);
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
