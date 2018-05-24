package atcoder.ABC011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class ABC011C {
    int n;
    Set<Integer> set;

    public static void main(String args[]) {
        new ABC011C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        set = new HashSet<>();
        set.add(sc.nextInt());
        set.add(sc.nextInt());
        set.add(sc.nextInt());
        solve();
    }

    void solve() {
        if (set.contains(n)) {
            System.out.println("NO");
            return;
        }
        int count = 0;
        while (n > 0) {
            if (count == 100) {
                System.out.println("NO");
                return;
            }
            if (!set.contains(n - 3)) {
                n -= 3;
            } else if (!set.contains(n - 2)) {
                n -= 2;
            } else if (!set.contains(n - 1)) {
                n--;
            } else {
                System.out.println("NO");
                return;
            }
            count++;
        }
        System.out.println("YES");
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
