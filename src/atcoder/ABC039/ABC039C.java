package atcoder.ABC039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ABC039C {
    String s;

    public static void main(String args[]) {
        new ABC039C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        s = sc.next();
        solve();
    }

    void solve() {
        String ans = "";
        if (s.startsWith("WBWBWWBWBWB")) {
            ans = "Do";
        } else if (s.startsWith("WBWWBWBWBWW")) {
            ans = "Re";
        } else if (s.startsWith("WWBWBWBWW")) {
            ans = "Mi";
        } else if (s.startsWith("WBWBWBWW")) {
            ans = "Fa";
        } else if (s.startsWith("WBWBWWBWBWW")) {
            ans = "So";
        } else if (s.startsWith("WBWWBWBWW")) {
            ans = "La";
        } else {
            ans = "Si";
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
