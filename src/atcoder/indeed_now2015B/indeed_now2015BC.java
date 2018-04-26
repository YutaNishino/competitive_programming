package atcoder.indeed_now2015B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class indeed_now2015BC {
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++){
            graph.add(new LinkedList<>());
        }
        for (int i = 1; i < n; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        int[] picked = new int[n];
        boolean[] checked = new boolean[n];
        checked[0] = true;
        int index = 0;
        Queue<Integer> pQueue = new PriorityQueue<>();
        pQueue.offer(0);
        while(!pQueue.isEmpty()) {
            int node = pQueue.poll();
            for (int next : graph.get(node)) {
                if (!checked[next]) {
                    checked[next] = true;
                    pQueue.offer(next);
                }
            }
            picked[index++] = node;
        }
        for(int i = 0; i < n; i++) {
            System.out.print(picked[i] + 1);
            if (i < n - 1) System.out.print(" ");
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
