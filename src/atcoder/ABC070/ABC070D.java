package atcoder.ABC070;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ABC070D {
    static ArrayList<LinkedList<TupleInt>> graph;
    static int n;
    static int q, k;
    static long[] distances;
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new LinkedList<TupleInt>());
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new TupleInt(b, c));
            graph.get(b).add(new TupleInt(a, c));
        }
        q = sc.nextInt();
        k = sc.nextInt();
        // distances from k
        distances = new long[n + 1];
        dfs();
        for (int i = 0; i < q; i++) {
            long dkx = distances[sc.nextInt()];
            long dky = distances[sc.nextInt()];
            System.out.println(dkx + dky);
        }
    }

    // distance from a to b
    static void dfs() {
        boolean[] visited = new boolean[n + 1];
        Stack<TupleLong> stack = new Stack<>();
        visited[k] = true;
        stack.push(new TupleLong(k, 0));
        while(!stack.isEmpty()) {
            TupleLong t = stack.pop();
            LinkedList<TupleInt> edges = graph.get(t.x);
            for (TupleInt edge : edges) {
                if (!visited[edge.x]) {
                    distances[edge.x] = t.y + edge.y;
                    visited[edge.x] = true;
                    stack.push(new TupleLong(edge.x, t.y + edge.y));
                }
            }
        }
    }

    static class TupleInt {
        final int x;
        final int y;
        TupleInt(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class TupleLong {
        final int x;
        final long y;
        TupleLong(int x, long y) {
            this.x = x;
            this.y = y;
        }
    }
}
