package atcoder.ABC090;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC090B {
    int a, b;

    public static void main(String args[]) {
        new ABC090B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        a = sc.nextInt();
        b = sc.nextInt();
        solve();
    }

    void solve() {
        int count = 0;
        for (int i = a; i <= b; i++) {
            if (isPalindrome(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    boolean isPalindrome(int n) {
        char[] cs = String.valueOf(n).toCharArray();
        for (int i = 0; i < cs.length / 2; i++) {
            if (cs[i] != cs[cs.length - i - 1]) {
                return false;
            }
        }
        return true;
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
