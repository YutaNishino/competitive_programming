package atcoder.ABC077;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class ABC077D {
    int k;

    public static void main(String args[]) {
        new ABC077D().run();
    }

    void run() {
        FastReader sc = new FastReader();
        k = sc.nextInt();
        solve();
    }

    void solve() {
        Deque<Pair> deque = new LinkedList<>();
        boolean[] visited = new boolean[k];
        deque.offer(new Pair(1, 1));
        while (!deque.isEmpty()) {
            Pair p = deque.poll();
            if (p.node == 0) {
                System.out.println(p.sumDigits);
                return;
            }
            visited[p.node] = true;
            int add1 = (p.node + 1) % k;
            int multi10 = (p.node * 10) % k;
            if (!visited[add1]) {
                deque.offerLast(new Pair(add1, p.sumDigits + 1));
            }
            if (!visited[multi10]) {
                deque.offerFirst(new Pair(multi10, p.sumDigits));
            }
        }
    }

    class Pair {
        int node;
        int sumDigits;

        Pair(int node, int sumDigits) {
            this.node = node;
            this.sumDigits = sumDigits;
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
