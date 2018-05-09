package atcoder.ABC016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ABC016C {
    int n, m;
    List<List<Integer>> graph;

    public static void main(String args[]) {
        new ABC016C().run();
    }

    void run() {
        FastReader sc = new FastReader();
        n = sc.nextInt();
        m = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }
        for (int i = 0; i < m; i++) {
            int from = sc.nextInt() - 1;
            int to = sc.nextInt() - 1;
            graph.get(from).add(to);
            graph.get(to).add(from);
        }
        solve();
    }

    void solve() {
        int[] fofFs = new int[n];
        for (int i = 0; i < n; i++) {
            Set<Integer> friends = new HashSet<>();
            Set<Integer> tempFofFs = new HashSet<>();
            friends.add(i);
            for (int friend : graph.get(i)) {
                friends.add(friend);
                for (int fofF : graph.get(friend)) {
                    tempFofFs.add(fofF);
                }
            }
            int count = 0;
            for (int fofF : tempFofFs) {
                if (!friends.contains(fofF)) {
                    count++;
                }
            }
            System.out.println(count);
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
