package atcoder.ARC087;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ARC087B {
    ArrayList<Character> ss, ts;

    public static void main(String args[]) {
        new ARC087B().run();
    }

    void run() {
        FastReader sc = new FastReader();
        char[] tempSs = sc.next().toCharArray();
        char[] tempTs = sc.next().toCharArray();
        ss = new ArrayList<>();
        ts = new ArrayList<>();
        for (int i = 0; i < tempSs.length; i++) {
            ss.add(tempSs[i]);
        }
        for (int i = 0; i < tempTs.length; i++) {
            ts.add(tempTs[i]);
        }
        solve();
    }

    void solve() {
        Collections.sort(ss);
        Collections.sort(ts, Collections.reverseOrder());
        Iterator<Character> ssIt = ss.iterator();
        Iterator<Character> tsIt = ts.iterator();
        while (ssIt.hasNext() && tsIt.hasNext()) {
            char s = ssIt.next();
            char t = tsIt.next();
            if (s < t) {
                System.out.println("Yes");
                return;
            } else if (s > t) {
                System.out.println("No");
                return;
            }
        }
        if (tsIt.hasNext()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
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
