package codeforces.Div3_479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Div3_479D {
    int n;
    long[] as;

    public static void main(String args[]) {
        new Div3_479D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        as = new long[n];
        for (int i = 0; i < n; i++) {
            as[i] = sc.nextLong();
        }
        solve();
    }

    void solve() {
        Deque<Long> deque = new LinkedList<>();
        deque.offer(as[0]);
        boolean[] done = new boolean[n];
        done[0] = true;
        while (deque.size() < n) {
            for (int j = 1; j < n; j++) {
                if (done[j]) continue;
                long first = deque.peekFirst();
                long last = deque.peekLast();
                if (as[j] == 3 * first || as[j] * 2 == first) {
                    deque.offerFirst(as[j]);
                    done[j] = true;
                    break;
                } else if (as[j] == 2 * last || as[j] * 3 == last) {
                    deque.offerLast(as[j]);
                    done[j] = true;
                    break;
                }
            }
        }
        while (!deque.isEmpty()) {
            System.out.print(deque.poll());
            if (deque.size() >= 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
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
