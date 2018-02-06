package library.datastructure;

// Implement size of each tree as well as union and find
public class UnionFind {
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
