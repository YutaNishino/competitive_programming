package library.algorithm.Graph;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class LowestCommonAncestor {
    List<List<Integer>> graph;
    int[][] parents;
    int[] depth;

    LowestCommonAncestor(List<List<Integer>> graph) {
        this.graph = graph;
        int n = graph.size();
        int logN = (int)Math.ceil(Math.log(n)/Math.log(2)+1e-10);
        parents = new int[logN][n];
        depth = new int[n];
        init(0, -1, 0);
        initParents();
    }

    int lca(int u, int v) {
        if (depth[u] > depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }
        for (int i = 0; i < parents.length; i++) {
            if (((depth[v] - depth[u]) >> i & 1) > 0) {
                v = parents[i][v];
            }
        }
        if (u == v) {
            return u;
        }
        for (int i = parents.length - 1; i >= 0; i--) {
            if (parents[i][u] != parents[i][v]) {
                u = parents[i][u];
                v = parents[i][v];
            }
        }
        return parents[0][u];
    }

    void init(int v, int p, int d) {
        Deque<State> stack = new LinkedList<>();
        stack.push(new State(v, p, d));
        while (!stack.isEmpty()) {
            State s = stack.pop();
            parents[0][s.v] = s.p;
            depth[s.v] = s.d;
            for (int next : graph.get(s.v)) {
                if (next != s.p) {
                    stack.push(new State(next, s.v, s.d + 1));
                }
            }
        }
    }

    void initParents() {
        for (int i = 0; i < parents.length - 1; i++) {
            for (int j = 0; j < parents[0].length; j++) {
                if (parents[i][j] < 0) {
                    parents[i + 1][j] = -1;
                } else {
                    parents[i + 1][j] = parents[i][parents[i][j]];
                }
            }
        }
    }
}

class State {
    int v;
    int p;
    int d;

    State(int v, int p, int d) {
        this.v = v;
        this.p = p;
        this.d = d;
    }
}
