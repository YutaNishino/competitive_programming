package codeforces.Div2_464;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Div2_464D {
    static List<LinkedList<Character>> graph;
    static List<Character> chars;
    static boolean[] visited;
    public static void main(String args[]) {
        FastReader sc = new FastReader();
        int n = sc.nextInt();
        UnionFind uf = new UnionFind(26);
        char[] v = sc.next().toCharArray();
        char[] t = sc.next().toCharArray();
        ArrayList<String> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (v[i] != t[i] && uf.find(v[i] - 'a') != uf.find(t[i] - 'a')) {
                uf.unite(v[i] - 'a', t[i] - 'a');
                arr.add(v[i] + " " + t[i]);
            }
        }
        System.out.println(arr.size());
        for(String s: arr)
            System.out.println(s);
    }

    static List<Character> topSortRec(int i, int parent, List<Character> list) {
        visited[i] = true;
        System.out.println(chars.get(i));
        List<Character> edges = graph.get(i);
        list.add(0, chars.get(i));
        for (char c : edges) {
            int index = chars.indexOf(c);
            System.out.printf(" %c\n", c);
            if (!visited[index]) {
                topSortRec(index, i, list);
            }
        }
        return list;
    }

    static class Pair {
        char x;
        char y;

        public Pair(char x, char y) {
            this.x = x;
            this.y = y;
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

    static class UnionFind {
        int[] parent;
        // only roots have correct counts
        int[] count;

        public UnionFind(int size) {
            parent = new int[size];
            count = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
                count[i] = 1;
            }
        }

        // return the root of the input
        // adopt path compression
        public int find(int a) {
            if (parent[a] == a) return a;
            parent[a] = find(parent[a]);
            return parent[a];
        }

        // adopt weighted union rule
        public void unite(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (count[a] < count[b]) {
                parent[a] = b;
                count[b] += count[a];
            } else {
                parent[b] = a;
                count[a] += count[b];
            }
        }

        public boolean differ(int a, int b) {
            a = find(a);
            b = find(b);
            return a != b;
        }

        public int count(int a) {
            return count[find(a)];
        }
    }
}
