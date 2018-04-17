package atcoder.ABC036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class ABC036C {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        Queue<Pair> pQueue = new PriorityQueue<>(n);
        for (int i = 0; i < n; i++) {
            pQueue.add(new Pair(i, sc.nextInt()));
        }
        int[] bs = new int[n];
        int bCount = -1;
        int aMax = -1;
        for (int i = 0; i < n; i++) {
            Pair p = pQueue.poll();
            if (p.value > aMax) {
                aMax = p.value;
                bCount++;
            }
            bs[p.index] = bCount;
        }
        for (int i = 0; i < n; i++) {
            System.out.println(bs[i]);
        }
    }

    static class Pair implements Comparable<Pair> {
        int index;
        int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair p) {
            return this.value - p.value;
        }
    }

    static class FastReader
    {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next()
        {
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

        String nextLine()
        {
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
