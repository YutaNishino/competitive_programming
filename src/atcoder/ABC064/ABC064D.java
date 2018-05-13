package atcoder.ABC064;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ABC064D {
    int n;
    Deque<Character> deque;
    char[] cs;

    public static void main(String args[]) {
        new ABC064D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        cs = sc.next().toCharArray();
        deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.offer(cs[i]);
        }
        solve();
    }

    void solve() {
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (cs[i] == '(') {
                count++;
            } else {
                count--;
            }
            while (count < 0) {
                deque.offerFirst('(');
                count++;
            }
        }
        while (count > 0) {
            deque.offer(')');
            count--;
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.poll());
        }
        System.out.println(sb);
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
