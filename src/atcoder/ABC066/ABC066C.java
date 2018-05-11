package atcoder.ABC066;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ABC066C {
    int n;

    public static void main(String args[]) {
        new ABC066C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                deque.offerLast(sc.nextInt());
            } else {
                deque.offerFirst(sc.nextInt());
            }
        }
        if (n % 2 == 1) {
            for (int i = 0; i < n; i++) {
                System.out.print(deque.pollLast());
                if (i < n - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                System.out.print(deque.pollFirst());
                if (i < n - 1) {
                    System.out.print(" ");
                } else {
                    System.out.println();
                }
            }
        }
    }

    void solve() {
        Deque<Integer> deque = new LinkedList<>();

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
