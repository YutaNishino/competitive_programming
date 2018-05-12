package library.datastructure;

// Implement size of each tree as well as union and find
class UnionFind {
    int[] parents;
    // only roots have correct counts
    int[] counts;

    public UnionFind(int size) {
        parents = new int[size];
        counts = new int[size];
        for (int i = 0; i < size; i++) {
            parents[i] = i;
            counts[i] = 1;
        }
    }

    // return the root of the input
    // adopt path compression
    public int find(int a) {
        if (parents[a] == a) return a;
        parents[a] = find(parents[a]);
        return parents[a];
    }

    // adopt weighted union rule
    public void unite(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;
        if (counts[a] < counts[b]) {
            parents[a] = b;
            counts[b] += counts[a];
        } else {
            parents[b] = a;
            counts[a] += counts[b];
        }
    }

    public boolean differ(int a, int b) {
        a = find(a);
        b = find(b);
        return a != b;
    }

    public int count(int a) {
        return counts[find(a)];
    }
}
