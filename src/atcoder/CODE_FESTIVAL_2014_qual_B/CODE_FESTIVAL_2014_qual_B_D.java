package atcoder.CODE_FESTIVAL_2014_qual_B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CODE_FESTIVAL_2014_qual_B_D {
    int n;
    int[] hs;

    public static void main(String args[]) {
        new CODE_FESTIVAL_2014_qual_B_D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        hs = new int[n + 2];
        for (int i = 1; i <= n; i++) {
            hs[i] = sc.nextInt();
        }
        hs[0] = Integer.MAX_VALUE;
        hs[n + 1] = Integer.MAX_VALUE;
        solve();
    }

    void solve() {
        Deque<Integer> stack = new LinkedList<>();
        int[] seens = new int[n + 1];
        for (int i = n + 1; i >= 1; i--) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (hs[stack.peek()] > hs[i]) {
                    stack.push(i);
                } else  {
                    while (hs[stack.peek()] <= hs[i]) {
                        stack.pop();
                    }
                    seens[i] += stack.peek() - i - 1;
                    stack.push(i);
                }
            }
        }
        stack.clear();
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                if (hs[stack.peek()] > hs[i]) {
                    stack.push(i);
                } else  {
                    while (hs[stack.peek()] <= hs[i]) {
                        stack.pop();
                    }
                    seens[i] += i - stack.peek() - 1;
                    stack.push(i);
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            System.out.println(seens[i]);
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
